/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author User
 */
//package schoolclinic.ui;
import javafx.animation.PauseTransition;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.control.*;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.util.Duration;

import java.util.List;

public class StudentPickerDialog extends Dialog<StudentPick> {

    private final TextField search = new TextField();
    private final TableView<StudentPick> table = new TableView<>();
    private final ObservableList<StudentPick> rows = FXCollections.observableArrayList();
    private final PauseTransition debounce = new PauseTransition(Duration.millis(250));

    public StudentPickerDialog() {
        setTitle("Pick Student");
        setHeaderText("Search by ID number or name, then select.");

        // --- Search bar
        search.setPromptText("Search by ID number or name…");
        Button searchBtn = new Button("Search");
        searchBtn.setOnAction(e -> runSearch());

        HBox top = new HBox(8, search, searchBtn);
        HBox.setHgrow(search, Priority.ALWAYS);
        top.setPadding(new Insets(10));

        // --- Table (ID Number + Name)
        TableColumn<StudentPick, String> colIdNum = new TableColumn<>("ID Number");
        colIdNum.setPrefWidth(140);
        colIdNum.setCellValueFactory(c ->
            javafx.beans.binding.Bindings.createStringBinding(c.getValue()::getIdNumber));

        TableColumn<StudentPick, String> colName = new TableColumn<>("Name");
        colName.setPrefWidth(320);
        colName.setCellValueFactory(c ->
            javafx.beans.binding.Bindings.createStringBinding(c.getValue()::getFullName));

        table.getColumns().addAll(colIdNum, colName);
        table.setItems(rows);
        table.setPlaceholder(new Label("Type above and press Enter or click Search"));
        table.setOnMouseClicked(e -> {
            if (e.getClickCount() == 2 && table.getSelectionModel().getSelectedItem() != null) {
                okAndClose();
            }
        });

        // Enter in search triggers search
        search.setOnKeyPressed(e -> { if (e.getCode() == KeyCode.ENTER) runSearch(); });
        // Debounced search while typing
        search.textProperty().addListener((o, a, b) -> {
            debounce.setOnFinished(ev -> runSearch());
            debounce.playFromStart();
        });

        BorderPane root = new BorderPane();
        root.setTop(top);
        root.setCenter(table);
        getDialogPane().setContent(root);

        // --- Buttons (OK/CANCEL) ---
        ButtonType okType = ButtonType.OK;
        getDialogPane().getButtonTypes().addAll(okType, ButtonType.CANCEL);

        Button okBtn = (Button) getDialogPane().lookupButton(okType);
        okBtn.setText("Select");
        okBtn.setDisable(true);
        okBtn.setOnAction(e -> okAndClose());

        table.getSelectionModel().selectedItemProperty().addListener((obs, oldSel, newSel) -> {
            okBtn.setDisable(newSel == null);
        });

        table.setOnKeyPressed(e -> {
            if (e.getCode() == KeyCode.ENTER && table.getSelectionModel().getSelectedItem() != null) {
                okAndClose();
            }
        });

        // Result mapping
        setResultConverter(btn -> (btn == okType) ? table.getSelectionModel().getSelectedItem() : null);

        setResizable(true);
        setWidth(540);
        setHeight(500);
    }

    private void runSearch() {
        String q = search.getText();
        // Replace with own DAO call
        List<StudentPick> list = StudentDAO.searchPicksByNameOrIdNumber(q);
        rows.setAll(list);
        if (!rows.isEmpty()) table.getSelectionModel().select(0);
    }

    private void okAndClose() {
        close(); // result is provided by setResultConverter
    }
}



