
import java.io.File;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Dialog;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.BorderPane;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javafx.geometry.Insets;
import javafx.scene.layout.HBox;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author User
 */
public class RecycleBinDialog extends Dialog<Void> {
    private final TableView<DeletedRow> table = new TableView<>();
    private final ObservableList<DeletedRow> rows = FXCollections.observableArrayList();
    private final Runnable onChange;   // callback to refresh main table

    public RecycleBinDialog(Runnable onChange) {
        this.onChange = (onChange == null) ? () -> {} : onChange;

        setTitle("Recycle Bin");
        setHeaderText("     Restore or permanently delete certificates.     ");

        // Table
        TableColumn<DeletedRow, String> c1 = new TableColumn<>("Code");
        c1.setCellValueFactory(d -> new SimpleStringProperty(d.getValue().code));
        TableColumn<DeletedRow, String> c2 = new TableColumn<>("Student");
        c2.setCellValueFactory(d -> new SimpleStringProperty(d.getValue().student));
        TableColumn<DeletedRow, String> c3 = new TableColumn<>("Deleted At");
        c3.setCellValueFactory(d -> new SimpleStringProperty(d.getValue().deletedAt));
        table.getColumns().addAll(c1,c2,c3);
        table.setItems(rows);

        // Buttons INSIDE content so dialog stays open
        Button restoreBtn = new Button("Restore");
        Button hardDelBtn = new Button("Delete Permanently");
        Button closeBtn   = new Button("Close");

        restoreBtn.setOnAction(e -> {
            DeletedRow row = table.getSelectionModel().getSelectedItem();
            if (row == null) return;
            if (restore(row.certId)) {
                loadDeleted();   // refresh this dialog's list
                onChange.run();  // refresh main table immediately
                info("Restored.");
            }
        });
        hardDelBtn.setOnAction(e -> {
            DeletedRow row = table.getSelectionModel().getSelectedItem();
            if (row == null) return;
            if (confirm("Permanently delete this certificate? This cannot be undone.")) {
                if (hardDelete(row.certId)) {
                    loadDeleted();
                    onChange.run();
                    info("Permanently deleted.");
                }
            }
        });
        closeBtn.setOnAction(e -> close());

        HBox actions = new HBox(10, restoreBtn, hardDelBtn, closeBtn);
        actions.setPadding(new Insets(8));

        BorderPane root = new BorderPane();
        root.setCenter(table);
        root.setBottom(actions);

        getDialogPane().setContent(root);
        // Keep only a Close button type so Esc works; doesn't affect our own closeBtn
        getDialogPane().getButtonTypes().add(ButtonType.CLOSE);

        setResizable(true);
        setWidth(1000);
        setHeight(520);

        loadDeleted();
    }

    private void loadDeleted() {
        rows.clear();
        try (Connection con = MySQL.connect(); PreparedStatement ps = con.prepareStatement(
            "SELECT mc.cert_id, mc.cert_code, " +
            "CONCAT(st.last_name, ', ', st.first_name, ' ', COALESCE(st.middle_name,'')) fullname, " +
            "DATE_FORMAT(mc.deleted_at, '%Y-%m-%d %H:%i') AS deleted_at " +
            "FROM medical_certificates mc JOIN students st ON st.student_id=mc.student_id " +
            "WHERE mc.is_deleted=1 ORDER BY mc.deleted_at DESC")) {
            try(ResultSet rs = ps.executeQuery()){
                while (rs.next()){
                    rows.add(new DeletedRow(
                        rs.getInt("cert_id"),
                        rs.getString("cert_code"),
                        rs.getString("fullname"),
                        rs.getString("deleted_at")
                    ));
                }
            }
        } catch (SQLException e){ e.printStackTrace(); }
    }

    /** Move file back, flip flags; return true on success */
    private boolean restore(int certId){
        try (Connection con = MySQL.connect()){
            con.setAutoCommit(false);

            String recycle=null, original=null;
            try (PreparedStatement ps = con.prepareStatement(
                "SELECT file_path, original_file_path FROM medical_certificates WHERE cert_id=? AND is_deleted=1")) {
                ps.setInt(1, certId);
                try(ResultSet rs = ps.executeQuery()){
                    if (!rs.next()) { warn("Not found."); con.rollback(); return false; }
                    recycle = rs.getString(1);
                    original = rs.getString(2);
                }
            }
            if (recycle != null && original != null){
                File f = new File(recycle);
                File target = new File(original);
                target.getParentFile().mkdirs();
                if (f.exists()) { f.renameTo(target); }
            }

            try (PreparedStatement ps = con.prepareStatement(
                "UPDATE medical_certificates SET is_deleted=0, deleted_at=NULL, file_path=COALESCE(original_file_path,file_path), original_file_path=NULL WHERE cert_id=?")) {
                ps.setInt(1, certId);
                ps.executeUpdate();
            }

            MySQL.insertAudit(con, certId, "RESTORE", null);
            con.commit();
            return true;
        } catch (SQLException e){ e.printStackTrace(); warn("Restore failed:\n"+e.getMessage()); return false; }
    }

    /** Delete file + row; return true on success */
    private boolean hardDelete(int certId){
        try (Connection con = MySQL.connect()){
            con.setAutoCommit(false);

            String recycle=null;
            try (PreparedStatement ps = con.prepareStatement(
                "SELECT file_path FROM medical_certificates WHERE cert_id=? AND is_deleted=1")) {
                ps.setInt(1, certId);
                try(ResultSet rs = ps.executeQuery()){
                    if (rs.next()) recycle = rs.getString(1);
                }
            }
            if (recycle != null) {
                File f = new File(recycle);
                if (f.exists()) f.delete();
            }
            try (PreparedStatement ps = con.prepareStatement(
                "DELETE FROM medical_certificates WHERE cert_id=?")) {
                ps.setInt(1, certId);
                ps.executeUpdate();
            }
            MySQL.insertAudit(con, certId, "HARD_DELETE", "Admin");
            con.commit();
            return true;
        } catch (SQLException e){ e.printStackTrace(); warn("Delete failed:\n"+e.getMessage()); return false; }
    }

    private void info(String m){ new Alert(Alert.AlertType.INFORMATION, m).showAndWait(); }
    private void warn(String m){ new Alert(Alert.AlertType.ERROR, m).showAndWait(); }

    // simple row model
    public static class DeletedRow {
        public final int certId; public final String code; public final String student; public final String deletedAt;
        public DeletedRow(int id, String c, String s, String d){ certId=id; code=c; student=s; deletedAt=d; }
    }
    
    /** Show a yes/no confirmation dialog */
    private boolean confirm(String msg) {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION, msg, ButtonType.OK, ButtonType.CANCEL);
        alert.setHeaderText("Please Confirm");
        alert.setTitle("Confirmation");
        var result = alert.showAndWait();
        return result.isPresent() && result.get() == ButtonType.OK;
    }

}
