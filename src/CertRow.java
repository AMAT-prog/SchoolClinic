/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author User
 */

import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.control.SeparatorMenuItem;
import javafx.scene.layout.HBox;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.function.Consumer;

public class CertRow {
    private final StringProperty studentName = new SimpleStringProperty();
    private final StringProperty date        = new SimpleStringProperty();
    private final StringProperty code        = new SimpleStringProperty();
    private final StringProperty status      = new SimpleStringProperty();
    private final SimpleObjectProperty<HBox> action = new SimpleObjectProperty<>();
    private final int certId;

    public CertRow(int certId,
                   String studentName,
                   LocalDate issuedDate,
                   String code,
                   String status,
                   Consumer<Integer> onView,
                   Consumer<Integer> onPrint,
                   Consumer<Integer> onOpen,
                   Consumer<Integer> onDelete) {
        this.certId = certId;
        this.studentName.set(studentName);
        this.date.set(issuedDate == null ? "" : issuedDate.format(DateTimeFormatter.ISO_DATE));
        this.code.set(code);
        this.status.set(status);

        // Single Actions button
        MenuItem view   = new MenuItem("View");
        MenuItem print  = new MenuItem("Print");
        MenuItem open   = new MenuItem("Open");
        MenuItem del    = new MenuItem("Delete…");
        view.setOnAction(e -> onView.accept(certId));
        print.setOnAction(e -> onPrint.accept(certId));
        open.setOnAction(e -> onOpen.accept(certId));
        del.setOnAction(e -> onDelete.accept(certId));

        MenuButton actions = new MenuButton("Actions");
        actions.getItems().addAll(view, print, open, new SeparatorMenuItem(), del);
        actions.setStyle("-fx-padding: 2 8; -fx-background-radius: 8;");

        this.action.set(new HBox(actions));
    }

    public static CertRow of(int certId, String code, LocalDate issuedDate, String studentName,
                             String status, Consumer<Integer> onView, Consumer<Integer> onPrint,
                             Consumer<Integer> onOpen, Consumer<Integer> onDelete) {
        return new CertRow(certId, studentName, issuedDate, code, status, onView, onPrint, onOpen, onDelete);
    }

    public StringProperty studentNameProp(){ return studentName; }
    public StringProperty dateProp(){ return date; }
    public StringProperty codeProp(){ return code; }
    public StringProperty statusProp(){ return status; }
    public SimpleObjectProperty<HBox> actionProp(){ return action; }
}


