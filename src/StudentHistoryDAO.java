/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author User
 */
import java.sql.*;

public class StudentHistoryDAO {

    public StudentHistory findByStudentId(int studentId) throws SQLException {
        String sql = """
            SELECT history_id, student_id, past_illnesses, allergies, medications, immunizations, family_history
            FROM student_history
            WHERE student_id = ?
        """;

        try (Connection con = MySQL.connect();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, studentId);
            try (ResultSet rs = ps.executeQuery()) {
                if (!rs.next()) return null;

                StudentHistory h = new StudentHistory(rs.getInt("student_id"));
                h.setHistoryId(rs.getInt("history_id"));
                h.setPastIllnesses(rs.getString("past_illnesses"));
                h.setAllergies(rs.getString("allergies"));
                h.setMedications(rs.getString("medications"));
                h.setImmunizations(rs.getString("immunizations"));
                h.setFamilyHistory(rs.getString("family_history"));
                return h;
            }
        }
    }

    /** Insert or update in one call (requires UNIQUE on student_id). */
    public void upsert(StudentHistory h) throws SQLException {
        String sql = """
            INSERT INTO student_history
                (student_id, past_illnesses, allergies, medications, immunizations, family_history)
            VALUES (?, ?, ?, ?, ?, ?)
            ON DUPLICATE KEY UPDATE
                past_illnesses = VALUES(past_illnesses),
                allergies      = VALUES(allergies),
                medications    = VALUES(medications),
                immunizations  = VALUES(immunizations),
                family_history = VALUES(family_history)
        """;

        try (Connection con = MySQL.connect();
             PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

            // Treat empty TextAreas as NULL in DB (nicer than empty strings)
            ps.setInt(1, h.getStudentId());
            setNullableText(ps, 2, h.getPastIllnesses());
            setNullableText(ps, 3, h.getAllergies());
            setNullableText(ps, 4, h.getMedications());
            setNullableText(ps, 5, h.getImmunizations());
            setNullableText(ps, 6, h.getFamilyHistory());

            ps.executeUpdate();

            // If it was a new insert, grab the generated ID (optional)
            try (ResultSet keys = ps.getGeneratedKeys()) {
                if (keys.next()) {
                    h.setHistoryId(keys.getInt(1));
                }
            }
        }
    }

    private static void setNullableText(PreparedStatement ps, int index, String v) throws SQLException {
        if (v == null || v.trim().isEmpty()) {
            ps.setNull(index, Types.LONGVARCHAR); // TEXT in MySQL
        } else {
            ps.setString(index, v.trim());
        }
    }
}

