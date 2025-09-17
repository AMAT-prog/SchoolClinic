/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author User
 */
public class StudentHistory {
    private Integer historyId;      // can be null on insert
    private int studentId;
    private String pastIllnesses;
    private String allergies;
    private String medications;
    private String immunizations;
    private String familyHistory;

    public StudentHistory(int studentId) {
        this.studentId = studentId;
    }

    // Getters/setters
    public Integer getHistoryId() { return historyId; }
    public void setHistoryId(Integer historyId) { this.historyId = historyId; }

    public int getStudentId() { return studentId; }
    public void setStudentId(int studentId) { this.studentId = studentId; }

    public String getPastIllnesses() { return pastIllnesses; }
    public void setPastIllnesses(String pastIllnesses) { this.pastIllnesses = pastIllnesses; }

    public String getAllergies() { return allergies; }
    public void setAllergies(String allergies) { this.allergies = allergies; }

    public String getMedications() { return medications; }
    public void setMedications(String medications) { this.medications = medications; }

    public String getImmunizations() { return immunizations; }
    public void setImmunizations(String immunizations) { this.immunizations = immunizations; }

    public String getFamilyHistory() { return familyHistory; }
    public void setFamilyHistory(String familyHistory) { this.familyHistory = familyHistory; }
}

