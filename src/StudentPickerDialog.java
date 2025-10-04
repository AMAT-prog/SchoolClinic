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
//import schoolclinic.db.MySQL;
//import schoolclinic.model.Student1;

import java.util.List;

public class StudentPickerDialog extends Dialog<Student1> {

    private final TextField search = new TextField();
    private final TableView<Student1> table = new TableView<>();
    private final ObservableList<Student1> rows = FXCollections.observableArrayList();
    private final PauseTransition debounce = new PauseTransition(Duration.millis(250));

    public StudentPickerDialog() {
        setTitle("Pick Student");
        setHeaderText("Search and select the student to issue a certificate to.");

        // --- Search bar
        search.setPromptText("Search by ID number or name…");
        Button searchBtn = new Button("Search");
        searchBtn.setOnAction(e -> runSearch());

        HBox top = new HBox(8, search, searchBtn);
        HBox.setHgrow(search, Priority.ALWAYS);
        top.setPadding(new Insets(10));

        // --- Table
        TableColumn<Student1, String> colId   = new TableColumn<>("ID");
        colId.setPrefWidth(90);
        colId.setCellValueFactory(c ->
                javafx.beans.binding.Bindings.createStringBinding(() -> String.valueOf(c.getValue().studentId)));

        TableColumn<Student1, String> colName = new TableColumn<>("Name");
        colName.setPrefWidth(300);
        colName.setCellValueFactory(c ->
                javafx.beans.binding.Bindings.createStringBinding(c.getValue()::fullName));

        table.getColumns().addAll(colId, colName);
        table.setItems(rows);
        table.setPlaceholder(new Label("Type above and press Enter or click Search"));
        table.setOnMouseClicked(e -> { if (e.getClickCount() == 2 && table.getSelectionModel().getSelectedItem()!=null) okAndClose(); });

        // Enter in search triggers search
        search.setOnKeyPressed(e -> { if (e.getCode() == KeyCode.ENTER) runSearch(); });
        // Debounced search while typing
        search.textProperty().addListener((o, a, b) -> { debounce.setOnFinished(ev -> runSearch()); debounce.playFromStart(); });

        BorderPane root = new BorderPane();
        root.setTop(top);
        root.setCenter(table);
        getDialogPane().setContent(root);

        // --- Buttons (OK/CANCEL) ---
        ButtonType okType = ButtonType.OK; // standard OK, we'll rename it
        getDialogPane().getButtonTypes().addAll(okType, ButtonType.CANCEL);

        Button okBtn = (Button) getDialogPane().lookupButton(okType);
        okBtn.setText("Select");
        okBtn.setDisable(true); // until a row is selected
        okBtn.setOnAction(e -> okAndClose());

        // Enable OK when a row is selected
        table.getSelectionModel().selectedItemProperty().addListener((obs, oldSel, newSel) -> {
            okBtn.setDisable(newSel == null);
        });

        // Make pressing ENTER on the table select the current row
        table.setOnKeyPressed(e -> { if (e.getCode() == KeyCode.ENTER && table.getSelectionModel().getSelectedItem()!=null) okAndClose(); });

        // Map the dialog result
        setResultConverter(btn -> (btn == okType) ? table.getSelectionModel().getSelectedItem() : null);

        setResizable(true);
        setWidth(520);
        setHeight(480);
    }

    private void runSearch() {
        String q = search.getText();
        List<Student1> list = MySQL.findStudents(q);
        rows.setAll(list);
        if (!rows.isEmpty()) table.getSelectionModel().select(0);
    }

    private void okAndClose() {
        // resultConverter already returns the selected item when OK is pressed
        // Simply close; the OK button will fire the converter
        close();
    }
}


