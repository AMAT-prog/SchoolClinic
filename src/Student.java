/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author User
 */
public class Student {
    private final int id;                 // students.student_id
    private final String lastName;
    private final String firstName;
    private final String middleName;
    private final String course;
    private final String yearLevel;
    private final String gender;
    private final Integer age;
    private final String contactNumber;

    public Student(int id, String lastName, String firstName, String middleName,
                   String course, String yearLevel, String gender, Integer age, String contactNumber) {
        this.id = id;
        this.lastName = lastName;
        this.firstName = firstName;
        this.middleName = middleName;
        this.course = course;
        this.yearLevel = yearLevel;
        this.gender = gender;
        this.age = age;
        this.contactNumber = contactNumber;
    }
    public int getId() { return id; }
    public String getLastName() { return lastName; }
    public String getFirstName() { return firstName; }
    public String getMiddleName() { return middleName; }
    public String getCourse() { return course; }
    public String getYearLevel() { return yearLevel; }
    public String getGender() { return gender; }
    public Integer getAge() { return age; }
    public String getContactNumber() { return contactNumber; }
}

