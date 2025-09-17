/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author User
 */
//package clinic.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class StudentDAO {

    private static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(
            "jdbc:mysql://localhost/school_clinic_db", "root", "root"
        );
    }

    public static Integer findIdByFullName(String fullName) {
        String sql = "SELECT student_id FROM students WHERE CONCAT(first_name, ' ', last_name)=?";
        try (Connection con = getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, fullName);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) return rs.getInt("student_id");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    
    // StudentDAO
    public static List<StudentOption> findAllStudentOptions() {
    List<StudentOption> list = new ArrayList<>();
    String sql = "SELECT student_id, CONCAT(first_name,' ',last_name,' (',id_number,')') AS disp FROM students ORDER BY last_name, first_name";
    try (Connection con = MySQL.connect();
         PreparedStatement ps = con.prepareStatement(sql);
         ResultSet rs = ps.executeQuery()) {
        while (rs.next()) {
            list.add(new StudentOption(rs.getInt("student_id"), rs.getString("disp")));
        }
    } catch (Exception e) { e.printStackTrace(); }
    return list;
}
    
    
    //FOR VISIT LOGS
    public static ObservableList<StudentOption> getStudentOptions() {
    ObservableList<StudentOption> items = FXCollections.observableArrayList();
    String sql = """
        SELECT s.student_id,
               CONCAT(s.last_name, ', ', s.first_name,
                      CASE WHEN s.id_number IS NULL OR s.id_number=''
                           THEN '' ELSE CONCAT(' (', s.id_number, ')') END) AS display
        FROM students s
        ORDER BY s.last_name, s.first_name
    """;
    try (Connection con = MySQL.connect();
         PreparedStatement ps = con.prepareStatement(sql);
         ResultSet rs = ps.executeQuery()) {

        while (rs.next()) {
            items.add(new StudentOption(
                rs.getInt("student_id"),
                rs.getString("display")
            ));
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
    return items;
    }
    
    public static String getDisplayName(Integer studentId) {
        if (studentId == null) return "(No student)";
        String sql = "SELECT CONCAT(last_name, ', ', first_name) FROM students WHERE student_id = ?";
        try (Connection con = MySQL.connect();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, studentId);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) return rs.getString(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return "(No student)";
    }
    
    public static int countActive() {
        final String sql = "SELECT COUNT(*) FROM students WHERE is_active = 1";
        try (Connection con = MySQL.connect();
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            return rs.next() ? rs.getInt(1) : 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return 0;
        }
    }



    
    
    /** Accepts student ID number (digits), "First Last" or "Last, First".
        Returns student_id or null if not found. */
//    public static Integer lookupStudentId(String input) {
//        if (input == null || input.isBlank()) return null;
//
//        String byIdNum = "SELECT student_id FROM students WHERE id_number = ? LIMIT 1";
//        String byFull  = """
//            SELECT student_id
//              FROM students
//             WHERE CONCAT(first_name, ' ', last_name) = ?
//                OR CONCAT(last_name, ', ', first_name) = ?
//             LIMIT 1
//        """;
//        try (Connection con = MySQL.connect()) {
//            // Try numeric id_number first
//            if (input.matches("\\d+")) {
//                try (PreparedStatement ps = con.prepareStatement(byIdNum)) {
//                    ps.setString(1, input);
//                    try (ResultSet rs = ps.executeQuery()) {
//                        if (rs.next()) return rs.getInt(1);
//                    }
//                }
//            }
//            // Try exact name match
//            try (PreparedStatement ps = con.prepareStatement(byFull)) {
//                ps.setString(1, input.trim());
//                ps.setString(2, input.trim());
//                try (ResultSet rs = ps.executeQuery()) {
//                    if (rs.next()) return rs.getInt(1);
//                }
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        return null; // allow null student_id (schema permits it)
//    }
//
//    /** For showing name after insert, by student_id. */
//    public static String getDisplayName(Integer studentId) {
//        if (studentId == null) return "(No student)";
//        String sql = "SELECT CONCAT(last_name, ', ', first_name) FROM students WHERE student_id = ?";
//        try (Connection con = MySQL.connect();
//             PreparedStatement ps = con.prepareStatement(sql)) {
//            ps.setInt(1, studentId);
//            try (ResultSet rs = ps.executeQuery()) {
//                if (rs.next()) return rs.getString(1);
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        return "(No student)";
//    }


}
