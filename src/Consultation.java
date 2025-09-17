/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author User
 */
//package your.package.name;

import java.time.LocalDate;

public class Consultation {
    private int consultationId;
    private int studentId;
    private String studentName;   // for display in TableView
    private LocalDate consultationDate;
    private String reasonForVisit;
    private String bloodPressure;
    private Double temperature;
    private String diagnosis;
    private String treatment;
    private String referral;

    // New vitals + statuses
    private Integer systolic;
    private Integer diastolic;
    private String bpStatus;
    private Integer pulseRate;
    private String pulseStatus;
    private Integer respiratoryRate;
    private String respiratoryStatus;

    // ----- Constructor -----
    public Consultation() {}

    public Consultation(int consultationId, int studentId, String studentName,
                        LocalDate consultationDate, String reasonForVisit,
                        String bloodPressure, Double temperature,
                        String diagnosis, String treatment, String referral,
                        Integer systolic, Integer diastolic, String bpStatus,
                        Integer pulseRate, String pulseStatus,
                        Integer respiratoryRate, String respiratoryStatus) {
        this.consultationId = consultationId;
        this.studentId = studentId;
        this.studentName = studentName;
        this.consultationDate = consultationDate;
        this.reasonForVisit = reasonForVisit;
        this.bloodPressure = bloodPressure;
        this.temperature = temperature;
        this.diagnosis = diagnosis;
        this.treatment = treatment;
        this.referral = referral;
        this.systolic = systolic;
        this.diastolic = diastolic;
        this.bpStatus = bpStatus;
        this.pulseRate = pulseRate;
        this.pulseStatus = pulseStatus;
        this.respiratoryRate = respiratoryRate;
        this.respiratoryStatus = respiratoryStatus;
    }

    // ----- Getters & Setters -----
    public int getConsultationId() { return consultationId; }
    public void setConsultationId(int consultationId) { this.consultationId = consultationId; }

    public int getStudentId() { return studentId; }
    public void setStudentId(int studentId) { this.studentId = studentId; }

    public String getStudentName() { return studentName; }
    public void setStudentName(String studentName) { this.studentName = studentName; }

    public LocalDate getConsultationDate() { return consultationDate; }
    public void setConsultationDate(LocalDate consultationDate) { this.consultationDate = consultationDate; }

    public String getReasonForVisit() { return reasonForVisit; }
    public void setReasonForVisit(String reasonForVisit) { this.reasonForVisit = reasonForVisit; }

    public String getBloodPressure() { return bloodPressure; }
    public void setBloodPressure(String bloodPressure) { this.bloodPressure = bloodPressure; }

    public Double getTemperature() { return temperature; }
    public void setTemperature(Double temperature) { this.temperature = temperature; }

    public String getDiagnosis() { return diagnosis; }
    public void setDiagnosis(String diagnosis) { this.diagnosis = diagnosis; }

    public String getTreatment() { return treatment; }
    public void setTreatment(String treatment) { this.treatment = treatment; }

    public String getReferral() { return referral; }
    public void setReferral(String referral) { this.referral = referral; }

    public Integer getSystolic() { return systolic; }
    public void setSystolic(Integer systolic) { this.systolic = systolic; }

    public Integer getDiastolic() { return diastolic; }
    public void setDiastolic(Integer diastolic) { this.diastolic = diastolic; }

    public String getBpStatus() { return bpStatus; }
    public void setBpStatus(String bpStatus) { this.bpStatus = bpStatus; }

    public Integer getPulseRate() { return pulseRate; }
    public void setPulseRate(Integer pulseRate) { this.pulseRate = pulseRate; }

    public String getPulseStatus() { return pulseStatus; }
    public void setPulseStatus(String pulseStatus) { this.pulseStatus = pulseStatus; }

    public Integer getRespiratoryRate() { return respiratoryRate; }
    public void setRespiratoryRate(Integer respiratoryRate) { this.respiratoryRate = respiratoryRate; }

    public String getRespiratoryStatus() { return respiratoryStatus; }
    public void setRespiratoryStatus(String respiratoryStatus) { this.respiratoryStatus = respiratoryStatus; }
}

