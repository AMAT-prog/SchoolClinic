/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author User
 */

import java.time.LocalDate;

public class VisitRow {
    public final LocalDate date;
    public final String student;
    public final String reason;

    public VisitRow(LocalDate date, String student, String reason) {
        this.date = date; this.student = student; this.reason = reason;
    }
    public LocalDate getDate() { return date; }
    public String getStudent() { return student; }
    public String getReason() { return reason; }
}

