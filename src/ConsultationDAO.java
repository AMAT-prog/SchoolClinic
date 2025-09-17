/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author User
 */
//package clinic.dao;

//import clinic.model.Consultation;
import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class ConsultationDAO {

    // Adjust your DB connection details
    private static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(
            "jdbc:mysql://localhost/school_clinic_db", "root", "root"
        );
    }

    // Fetch all consultations with student name
    public static List<Consultation> findAllWithStudentName() {
        List<Consultation> list = new ArrayList<>();
        String sql = """
            SELECT c.consultation_id, c.student_id,
                   CONCAT(s.first_name, ' ', s.last_name) AS student_name,
                   c.consultation_date, c.reason_for_visit,
                   c.blood_pressure, c.temperature, c.diagnosis,
                   c.treatment, c.referral,
                   c.systolic, c.diastolic, c.bp_status,
                   c.pulse_rate, c.pulse_status,
                   c.respiratory_rate, c.respiratory_status
            FROM consultations c
            JOIN students s ON c.student_id = s.student_id
            ORDER BY c.consultation_date DESC
        """;

        try (Connection con = getConnection();
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                Consultation c = new Consultation(
                    rs.getInt("consultation_id"),
                    rs.getInt("student_id"),
                    rs.getString("student_name"),
                    rs.getDate("consultation_date").toLocalDate(),
                    rs.getString("reason_for_visit"),
                    rs.getString("blood_pressure"),
                    rs.getDouble("temperature"),
                    rs.getString("diagnosis"),
                    rs.getString("treatment"),
                    rs.getString("referral"),
                    rs.getInt("systolic"),
                    rs.getInt("diastolic"),
                    rs.getString("bp_status"),
                    rs.getInt("pulse_rate"),
                    rs.getString("pulse_status"),
                    rs.getInt("respiratory_rate"),
                    rs.getString("respiratory_status")
                );
                list.add(c);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    // Insert new consultation
    public static void insert(Integer studentId, LocalDate date, String reason, String bp, Double temp,
                              String diagnosis, String treatment, String referral,
                              Integer pulseRate, Integer respRate) {
        String sql = """
            INSERT INTO consultations
            (student_id, consultation_date, reason_for_visit, blood_pressure, temperature,
             diagnosis, treatment, referral, pulse_rate, respiratory_rate)
            VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)
        """;

        try (Connection con = getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, studentId);
            ps.setDate(2, Date.valueOf(date));
            ps.setString(3, reason);
            ps.setString(4, bp);
            ps.setObject(5, temp);
            ps.setString(6, diagnosis);
            ps.setString(7, treatment);
            ps.setString(8, referral);
            ps.setObject(9, pulseRate);
            ps.setObject(10, respRate);
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Update consultation
    public static void update(int id, Integer studentId, LocalDate date, String reason, String bp, Double temp,
                              String diagnosis, String treatment, String referral,
                              Integer pulseRate, Integer respRate) {
        String sql = """
            UPDATE consultations
            SET student_id=?, consultation_date=?, reason_for_visit=?, blood_pressure=?, temperature=?,
                diagnosis=?, treatment=?, referral=?, pulse_rate=?, respiratory_rate=?
            WHERE consultation_id=?
        """;

        try (Connection con = getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, studentId);
            ps.setDate(2, Date.valueOf(date));
            ps.setString(3, reason);
            ps.setString(4, bp);
            ps.setObject(5, temp);
            ps.setString(6, diagnosis);
            ps.setString(7, treatment);
            ps.setString(8, referral);
            ps.setObject(9, pulseRate);
            ps.setObject(10, respRate);
            ps.setInt(11, id);
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Delete consultation
    public static void delete(int id) {
        String sql = "DELETE FROM consultations WHERE consultation_id=?";
        try (Connection con = getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

