/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author User
 */

import java.time.LocalDate;
import javafx.beans.property.*;

public class VisitLogRow {
    private final IntegerProperty visitId = new SimpleIntegerProperty();
    private final ObjectProperty<LocalDate> visitDate = new SimpleObjectProperty<>();
    private final IntegerProperty studentId = new SimpleIntegerProperty();
    private final StringProperty studentName = new SimpleStringProperty();
    private final StringProperty reason = new SimpleStringProperty();

    public VisitLogRow(int visitId, LocalDate visitDate, Integer studentId, String studentName, String reason) {
        setVisitId(visitId);
        setVisitDate(visitDate);
        if (studentId != null) setStudentId(studentId);
        setStudentName(studentName);
        setReason(reason);
    }

    public int getVisitId() { return visitId.get(); }
    public void setVisitId(int v) { visitId.set(v); }
    public IntegerProperty visitIdProperty() { return visitId; }

    public LocalDate getVisitDate() { return visitDate.get(); }
    public void setVisitDate(LocalDate d) { visitDate.set(d); }
    public ObjectProperty<LocalDate> visitDateProperty() { return visitDate; }

    public int getStudentId() { return studentId.get(); }
    public void setStudentId(int v) { studentId.set(v); }
    public IntegerProperty studentIdProperty() { return studentId; }

    public String getStudentName() { return studentName.get(); }
    public void setStudentName(String s) { studentName.set(s); }
    public StringProperty studentNameProperty() { return studentName; }

    public String getReason() { return reason.get(); }
    public void setReason(String r) { reason.set(r); }
    public StringProperty reasonProperty() { return reason; }
}

