/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author User
 */
//for med cert
public class Student1 {
    public final int studentId;
    public final String firstName;
    public final String lastName;
    public final String middle;

    public Student1(int id, String fn, String ln, String mi){
        this.studentId = id; this.firstName = fn; this.lastName = ln; this.middle = mi==null?"":mi;
    }
    public String fullName(){ return lastName + ", " + firstName + (middle.isEmpty()? "" : " " + middle); }
}

