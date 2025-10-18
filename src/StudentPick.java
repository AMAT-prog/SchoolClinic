/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author User
 */
// for visit log (selecting/searching student)

public final class StudentPick {
    private final int studentId;      // DB PK
    private final String idNumber;    // school-issued
    private final String fullName;    // display text

    public StudentPick(int studentId, String idNumber, String fullName) {
        this.studentId = studentId;
        this.idNumber = idNumber;
        this.fullName = fullName;
    }
    public int getStudentId()   { return studentId; }
    public String getIdNumber() { return idNumber; }
    public String getFullName() { return fullName; }

    @Override public String toString() { return idNumber + " – " + fullName; }
}

