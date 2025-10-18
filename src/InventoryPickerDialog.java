
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Dialog;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author User
 */
public class InventoryPickerDialog extends Dialog<Inventory> {

    private final TableView<Inventory> tv = new TableView<>();
    private final TextField search = new TextField();

    public InventoryPickerDialog() {
        setTitle("Pick Medicine");
        setHeaderText("Search and select a medicine.");
        getDialogPane().getButtonTypes().addAll(ButtonType.OK, ButtonType.CANCEL);

        TableColumn<Inventory,String> cName = new TableColumn<>("Medicine");
        cName.setCellValueFactory(d -> d.getValue().itemNameProperty());
        cName.setPrefWidth(260);

        TableColumn<Inventory,String> cUnit = new TableColumn<>("Unit");
        cUnit.setCellValueFactory(d -> d.getValue().unitProperty());
        cUnit.setPrefWidth(90);

        TableColumn<Inventory,String> cBal = new TableColumn<>("Balance");
        cBal.setCellValueFactory(d -> new SimpleStringProperty(
                String.valueOf(d.getValue().getBalanceStock())));
        cBal.setPrefWidth(90);

        tv.getColumns().addAll(cName, cUnit, cBal);

        search.setPromptText("Search…");
        search.textProperty().addListener((o,a,b) -> load(b));
        load(null);

        BorderPane root = new BorderPane(tv, search, null, null, null);
        getDialogPane().setContent(root);

        setResultConverter(btn -> btn == ButtonType.OK
                ? tv.getSelectionModel().getSelectedItem()
                : null);

        setResizable(true);
        setWidth(620);
        setHeight(520);
    }

    private void load(String q) {
        tv.setItems(InventoryDAO.listForPicker(q));
    }
}
