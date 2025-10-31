/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author User
 */

import java.time.LocalDate;

public class ConsRow {
    public final LocalDate date;
    public final String student;
    public final String reason;
    public final String diagnosis;
    public final String bp;
    public final Double temperature;

    public ConsRow(LocalDate date, String student, String reason, String diagnosis, String bp, Double temperature) {
        this.date = date; this.student = student; this.reason = reason; this.diagnosis = diagnosis; this.bp = bp; this.temperature = temperature;
    }
    public LocalDate getDate() { return date; }
    public String getStudent() { return student; }
    public String getReason() { return reason; }
    public String getDiagnosis() { return diagnosis; }
    public String getBp() { return bp; }
    public Double getTemperature() { return temperature; }
}

