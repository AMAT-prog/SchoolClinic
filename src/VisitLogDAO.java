/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author User
 */
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.*;
import java.time.LocalDate;

public class VisitLogDAO {

    public static ObservableList<VisitLogRow> findAll() {
        ObservableList<VisitLogRow> list = FXCollections.observableArrayList();
        String sql = """
            SELECT v.visit_id,
                   v.visit_date,
                   v.student_id,
                   COALESCE(CONCAT(s.last_name, ', ', s.first_name), '(No student)') AS student_name,
                   v.reason_for_visit
            FROM visit_log v
            LEFT JOIN students s ON s.student_id = v.student_id
            ORDER BY v.visit_date DESC, v.visit_id DESC
        """;
        try (Connection con = MySQL.connect();
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                int id = rs.getInt("visit_id");
                LocalDate d = rs.getDate("visit_date").toLocalDate();
                int sid = rs.getInt("student_id");
                if (rs.wasNull()) sid = 0; // optional
                String name = rs.getString("student_name");
                String reason = rs.getString("reason_for_visit");
                list.add(new VisitLogRow(id, d, sid == 0 ? null : sid, name, reason));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    /** Insert; returns generated visit_id (or -1 if failed). */
    public static int insert(LocalDate visitDate, Integer studentId, String reason) {
        String sql = "INSERT INTO visit_log (visit_date, student_id, reason_for_visit) VALUES (?,?,?)";
        try (Connection con = MySQL.connect();
             PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

            ps.setDate(1, Date.valueOf(visitDate));
            if (studentId != null) ps.setInt(2, studentId); else ps.setNull(2, Types.INTEGER);
            if (reason != null && !reason.isBlank()) ps.setString(3, reason); else ps.setNull(3, Types.LONGVARCHAR);

            int rows = ps.executeUpdate();
            if (rows == 1) {
                try (ResultSet rs = ps.getGeneratedKeys()) {
                    if (rs.next()) return rs.getInt(1);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return -1;
    }

    public static boolean deleteById(int visitId) {
        String sql = "DELETE FROM visit_log WHERE visit_id = ?";
        try (Connection con = MySQL.connect();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, visitId);
            return ps.executeUpdate() == 1;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
    
    public static int countToday() {
        final String sql = "SELECT COUNT(*) FROM visit_log WHERE visit_date = ?";
        LocalDate today = LocalDate.now();
        try (Connection con = MySQL.connect();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setDate(1, java.sql.Date.valueOf(today));
            try (ResultSet rs = ps.executeQuery()) {
                return rs.next() ? rs.getInt(1) : 0;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return 0;
        }
    }

}
