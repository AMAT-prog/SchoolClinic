/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author User
 */
//public class Student {
//    private final int id;
//    private final String lastName;
//    private final String firstName;
//    private final String middleName;
//    private final String course;
//    private final String yearLevel;
//    private final String gender;
//    private final Integer age;
//    private final String contactNumber;
//
//    // Add these:
//    private final String status;     // active, inactive, graduated
//    private final int isActive;      // 0, 1, 2
//
//    public Student(int id, String lastName, String firstName, String middleName,
//                   String course, String yearLevel, String gender, Integer age,
//                   String contactNumber, String status, int isActive) {
//        this.id = id;
//        this.lastName = lastName;
//        this.firstName = firstName;
//        this.middleName = middleName;
//        this.course = course;
//        this.yearLevel = yearLevel;
//        this.gender = gender;
//        this.age = age;
//        this.contactNumber = contactNumber;
//        this.status = status;
//        this.isActive = isActive;
//    }
//
//    // Existing getters...
//    public int getId() { return id; }
//    public String getLastName() { return lastName; }
//    public String getFirstName() { return firstName; }
//    public String getMiddleName() { return middleName; }
//    public String getCourse() { return course; }
//    public String getYearLevel() { return yearLevel; }
//    public String getGender() { return gender; }
//    public Integer getAge() { return age; }
//    public String getContactNumber() { return contactNumber; }
//
//    // New getters
//    public String getStatus() { return status; }
//    public int getIsActive() { return isActive; }
//}

// Student.java
public class Student {
    private final int id;              // students.student_id
    private final String idNumber;     // students.id_number  <-- for table display
    private final String lastName;
    private final String firstName;
    private final String middleName;
    private final String course;
    private final String yearLevel;
    private final String gender;
    private final Integer age;
    private final String contactNumber;

    // NEW: status + isActive for filters; image path for preview
    private final String status;       // active | inactive | graduated
    private final int isActive;        // 1=active, 0=inactive, 2=graduated
    private final String imagePath;    // varchar(300), may be null

    public Student(int id, String idNumber, String lastName, String firstName, String middleName,
                   String course, String yearLevel, String gender, Integer age, String contactNumber,
                   String status, int isActive, String imagePath) {
        this.id = id;
        this.idNumber = idNumber;
        this.lastName = lastName;
        this.firstName = firstName;
        this.middleName = middleName;
        this.course = course;
        this.yearLevel = yearLevel;
        this.gender = gender;
        this.age = age;
        this.contactNumber = contactNumber;
        this.status = status;
        this.isActive = isActive;
        this.imagePath = imagePath;
    }

    public int getId() { return id; }
    public String getIdNumber() { return idNumber; }
    public String getLastName() { return lastName; }
    public String getFirstName() { return firstName; }
    public String getMiddleName() { return middleName; }
    public String getCourse() { return course; }
    public String getYearLevel() { return yearLevel; }
    public String getGender() { return gender; }
    public Integer getAge() { return age; }
    public String getContactNumber() { return contactNumber; }
    public String getStatus() { return status; }
    public int getIsActive() { return isActive; }
    public String getImagePath() { return imagePath; }
}
