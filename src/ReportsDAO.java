/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author User
 */

import java.sql.*;
import java.time.LocalDate;
import java.util.*;

public class ReportsDAO {

    /* =======================
       ---------- KPI ----------
       ======================= */
    public int consultationsToday() throws Exception {
        String sql = """
            SELECT COUNT(*) FROM consultations
            WHERE consultation_date = CURDATE()
        """;
        try (Connection c = MySQL.connect(); PreparedStatement ps = c.prepareStatement(sql); ResultSet rs = ps.executeQuery()) {
            rs.next(); return rs.getInt(1);
        }
    }

    public int consultationsThisMonth() throws Exception {
        String sql = """
            SELECT COUNT(*) FROM consultations
            WHERE YEAR(consultation_date)=YEAR(CURDATE())
              AND MONTH(consultation_date)=MONTH(CURDATE())
        """;
        try (Connection c = MySQL.connect(); PreparedStatement ps = c.prepareStatement(sql); ResultSet rs = ps.executeQuery()) {
            rs.next(); return rs.getInt(1);
        }
    }

    public int activeStudents() throws Exception {
        // accept either is_active = 1 or status='active'
        String sql = """
            SELECT COUNT(*) FROM students
            WHERE (is_active=1 OR status='active')
        """;
        try (Connection c = MySQL.connect(); PreparedStatement ps = c.prepareStatement(sql); ResultSet rs = ps.executeQuery()) { rs.next(); return rs.getInt(1); }
    }

    public int totalMedsUsedAllTime() throws Exception {
        String sql = "SELECT IFNULL(SUM(qty),0) FROM consultation_meds";
        try (Connection c = MySQL.connect(); PreparedStatement ps = c.prepareStatement(sql); ResultSet rs = ps.executeQuery()) { rs.next(); return rs.getInt(1); }
    }

    /* =======================
       ---- Overview Charts ---
       ======================= */
    public List<KV> consultationsPerMonth(int year) throws Exception {
        String sql = """
            SELECT DATE_FORMAT(consultation_date, '%Y-%m') AS ym, COUNT(*) cnt
            FROM consultations
            WHERE YEAR(consultation_date)=?
            GROUP BY ym ORDER BY ym
        """;
        List<KV> data = new ArrayList<>();
        try (Connection c = MySQL.connect(); PreparedStatement ps = c.prepareStatement(sql)) {
            ps.setInt(1, year);
            try (ResultSet rs = ps.executeQuery()) { while (rs.next()) data.add(new KV(rs.getString("ym"), rs.getInt("cnt"))); }
        }
        return data;
    }

    public List<KV> topComplaints(int limit) throws Exception {
        String sql = """
            SELECT reason_for_visit AS k, COUNT(*) v
            FROM consultations
            WHERE reason_for_visit IS NOT NULL AND reason_for_visit <> ''
            GROUP BY reason_for_visit
            ORDER BY v DESC
            LIMIT ?
        """;
        List<KV> list = new ArrayList<>();
        try (Connection c = MySQL.connect(); PreparedStatement ps = c.prepareStatement(sql)) {
            ps.setInt(1, limit);
            try (ResultSet rs = ps.executeQuery()) { while (rs.next()) list.add(new KV(rs.getString("k"), rs.getInt("v"))); }
        }
        return list;
    }

    public Map<String,Integer> bpStatusCounts() throws Exception {
        String sql = "SELECT bp_status, COUNT(*) c FROM consultations GROUP BY bp_status";
        Map<String,Integer> m = new LinkedHashMap<>();
        try (Connection c = MySQL.connect(); PreparedStatement ps = c.prepareStatement(sql); ResultSet rs = ps.executeQuery()) {
            while (rs.next()) m.put(rs.getString(1), rs.getInt(2));
        }
        return m;
    }

    public List<KV> medsUsageTrendByMonth(int year) throws Exception {
        String sql = """
            SELECT DATE_FORMAT(created_at, '%Y-%m') ym, IFNULL(SUM(qty),0) used
            FROM consultation_meds
            WHERE created_at IS NOT NULL AND YEAR(created_at)=?
            GROUP BY ym ORDER BY ym
        """;
        List<KV> out = new ArrayList<>();
        try (Connection c = MySQL.connect(); PreparedStatement ps = c.prepareStatement(sql)) {
            ps.setInt(1, year);
            try (ResultSet rs = ps.executeQuery()) { while (rs.next()) out.add(new KV(rs.getString("ym"), rs.getInt("used"))); }
        }
        return out;
    }

    /* =======================
       ---- Consultations -----
       ======================= */
    public List<ConsRow> consultationsRange(LocalDate from, LocalDate to, String search) throws Exception {
        String base = """
            SELECT c.consultation_date, CONCAT(s.last_name, ', ', s.first_name) AS student,
                   c.reason_for_visit, c.diagnosis, c.blood_pressure, c.temperature
            FROM consultations c
            JOIN students s ON s.student_id = c.student_id
            WHERE c.consultation_date BETWEEN ? AND ?
        """;
        String like = (search!=null && !search.isBlank()) ? " AND (c.reason_for_visit LIKE ? OR c.diagnosis LIKE ?)" : "";
        String order = " ORDER BY c.consultation_date DESC";
        String sql = base + like + order;

        List<ConsRow> rows = new ArrayList<>();
        try (Connection cn = MySQL.connect(); PreparedStatement ps = cn.prepareStatement(sql)) {
            ps.setDate(1, java.sql.Date.valueOf(from));
            ps.setDate(2, java.sql.Date.valueOf(to));
            int i=3;
            if (!like.isEmpty()) { String pat = "%"+search+"%"; ps.setString(i++, pat); ps.setString(i++, pat); }
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) rows.add(new ConsRow(
                        rs.getDate(1).toLocalDate(),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getObject(6)!=null ? rs.getDouble(6) : null
                ));
            }
        }
        return rows;
    }

    public List<KV> consultationsMonthlyInRange(LocalDate from, LocalDate to) throws Exception {
        String sql = """
            SELECT DATE_FORMAT(consultation_date,'%Y-%m') ym, COUNT(*) cnt
            FROM consultations
            WHERE consultation_date BETWEEN ? AND ?
            GROUP BY ym ORDER BY ym
        """;
        List<KV> out = new ArrayList<>();
        try (Connection c = MySQL.connect(); PreparedStatement ps = c.prepareStatement(sql)) {
            ps.setDate(1, java.sql.Date.valueOf(from));
            ps.setDate(2, java.sql.Date.valueOf(to));
            try (ResultSet rs = ps.executeQuery()) { while (rs.next()) out.add(new KV(rs.getString(1), rs.getInt(2))); }
        }
        return out;
    }

    public List<KV> topComplaintsInRange(LocalDate from, LocalDate to) throws Exception {
        String sql = """
            SELECT reason_for_visit, COUNT(*) c
            FROM consultations
            WHERE consultation_date BETWEEN ? AND ?
              AND reason_for_visit IS NOT NULL AND reason_for_visit <> ''
            GROUP BY reason_for_visit ORDER BY c DESC LIMIT 5
        """;
        List<KV> out = new ArrayList<>();
        try (Connection c = MySQL.connect(); PreparedStatement ps = c.prepareStatement(sql)) {
            ps.setDate(1, java.sql.Date.valueOf(from));
            ps.setDate(2, java.sql.Date.valueOf(to));
            try (ResultSet rs = ps.executeQuery()) { while (rs.next()) out.add(new KV(rs.getString(1), rs.getInt(2))); }
        }
        return out;
    }

    public Map<String,Integer> bpStatusInRange(LocalDate from, LocalDate to) throws Exception {
        String sql = """
            SELECT bp_status, COUNT(*) c
            FROM consultations
            WHERE consultation_date BETWEEN ? AND ?
            GROUP BY bp_status
        """;
        Map<String,Integer> m = new LinkedHashMap<>();
        try (Connection c = MySQL.connect(); PreparedStatement ps = c.prepareStatement(sql)) {
            ps.setDate(1, java.sql.Date.valueOf(from));
            ps.setDate(2, java.sql.Date.valueOf(to));
            try (ResultSet rs = ps.executeQuery()) { while (rs.next()) m.put(rs.getString(1), rs.getInt(2)); }
        }
        return m;
    }

    /* =======================
       -------- Visits --------
       ======================= */
    public List<VisitRow> visitsRange(LocalDate from, LocalDate to) throws Exception {
        String sql = """
            SELECT v.visit_date, CONCAT(s.last_name, ', ', s.first_name) AS student, v.reason_for_visit
            FROM visit_log v JOIN students s ON s.student_id = v.student_id
            WHERE v.visit_date BETWEEN ? AND ?
            ORDER BY v.visit_date DESC
        """;
        List<VisitRow> list = new ArrayList<>();
        try (Connection c = MySQL.connect(); PreparedStatement ps = c.prepareStatement(sql)) {
            ps.setDate(1, java.sql.Date.valueOf(from));
            ps.setDate(2, java.sql.Date.valueOf(to));
            try (ResultSet rs = ps.executeQuery()) { while (rs.next()) list.add(new VisitRow(rs.getDate(1).toLocalDate(), rs.getString(2), rs.getString(3))); }
        }
        return list;
    }

    public List<KV> visitsByYearLevel(LocalDate from, LocalDate to) throws Exception {
        String sql = """
            SELECT s.year_level, COUNT(*) c
            FROM visit_log v JOIN students s ON s.student_id=v.student_id
            WHERE v.visit_date BETWEEN ? AND ?
            GROUP BY s.year_level ORDER BY c DESC
        """;
        return groupedCount(sql, from, to);
    }

    public List<KV> visitsByCourse(LocalDate from, LocalDate to) throws Exception {
        String sql = """
            SELECT s.course, COUNT(*) c
            FROM visit_log v JOIN students s ON s.student_id=v.student_id
            WHERE v.visit_date BETWEEN ? AND ?
            GROUP BY s.course ORDER BY c DESC
        """;
        return groupedCount(sql, from, to);
    }

    private List<KV> groupedCount(String sql, LocalDate from, LocalDate to) throws Exception {
        List<KV> out = new ArrayList<>();
        try (Connection c = MySQL.connect(); PreparedStatement ps = c.prepareStatement(sql)) {
            
            ps.setDate(1, java.sql.Date.valueOf(from));
            ps.setDate(2, java.sql.Date.valueOf(to));

            try (ResultSet rs = ps.executeQuery()) { while (rs.next()) out.add(new KV(
                    Optional.ofNullable(rs.getString(1)).orElse("Unknown"), rs.getInt(2))); }
        }
        return out;
    }

    /* =======================
       ------- Inventory -------
       ======================= */
    public List<MedUsageRow> medicineUsage(String search) throws Exception {
        // total used = SUM(consultation_meds.qty) per item; join inventory for balance + expiry
        String base = """
            SELECT i.item_name,
                   IFNULL(SUM(cm.qty),0) AS used,
                   IFNULL(i.quantity,0) AS balance,
                   i.expiry_date
            FROM inventory i
            LEFT JOIN consultation_meds cm ON cm.item_id=i.item_id
        """;
        String where = (search!=null && !search.isBlank()) ? " WHERE i.item_name LIKE ?" : "";
        String group = " GROUP BY i.item_id, i.item_name, i.quantity, i.expiry_date ORDER BY i.item_name";
        String sql = base + where + group;

        List<MedUsageRow> out = new ArrayList<>();
        try (Connection c = MySQL.connect(); PreparedStatement ps = c.prepareStatement(sql)) {
            if (!where.isEmpty()) ps.setString(1, "%"+search+"%");
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    out.add(new MedUsageRow(
                            rs.getString(1),
                            rs.getInt(2),
                            rs.getInt(3),
                            rs.getDate(4)!=null ? rs.getDate(4).toLocalDate() : null
                    ));
                }
            }
        }
        return out;
    }

    public List<MedUsageRow> lowStock(int threshold) throws Exception {
        String sql = """
            SELECT i.item_name, IFNULL(SUM(cm.qty),0) used, i.quantity, i.expiry_date
            FROM inventory i
            LEFT JOIN consultation_meds cm ON cm.item_id=i.item_id
            WHERE i.quantity <= ?
            GROUP BY i.item_id
            ORDER BY i.quantity ASC
        """;
        List<MedUsageRow> out = new ArrayList<>();
        try (Connection c = MySQL.connect(); PreparedStatement ps = c.prepareStatement(sql)) {
            ps.setInt(1, threshold);
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) out.add(new MedUsageRow(
                        rs.getString(1), rs.getInt(2), rs.getInt(3),
                        rs.getDate(4)!=null ? rs.getDate(4).toLocalDate() : null
                ));
            }
        }
        return out;
    }

    public List<MedUsageRow> expiringSoon(int days) throws Exception {
        String sql = """
            SELECT i.item_name, IFNULL(SUM(cm.qty),0) used, i.quantity, i.expiry_date
            FROM inventory i
            LEFT JOIN consultation_meds cm ON cm.item_id=i.item_id
            WHERE i.expiry_date IS NOT NULL
              AND i.expiry_date <= (CURDATE() + INTERVAL ? DAY)
            GROUP BY i.item_id
            ORDER BY i.expiry_date
        """;
        List<MedUsageRow> out = new ArrayList<>();
        try (Connection c = MySQL.connect(); PreparedStatement ps = c.prepareStatement(sql)) {
            ps.setInt(1, days);
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) out.add(new MedUsageRow(
                        rs.getString(1), rs.getInt(2), rs.getInt(3),
                        rs.getDate(4).toLocalDate()
                ));
            }
        }
        return out;
    }
}
