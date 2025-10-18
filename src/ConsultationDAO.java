/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author User
 */
import java.math.BigDecimal;
import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/** Data Access for Consultations (with medicines + inventory updates, transactional) */
public class ConsultationDAO {

    // Use shared connector
    private static Connection connect() throws SQLException {
        return MySQL.connect();
    }

    // ----------------------------- Queries -----------------------------

    // Original listing (kept, just uses connect())
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
            ORDER BY c.consultation_date DESC, c.consultation_id DESC
        """;

        try (Connection con = connect();
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                Consultation c = new Consultation(
                    rs.getInt("consultation_id"),
                    rs.getInt("student_id"),
                    rs.getString("student_name"),
                    rs.getDate("consultation_date") == null ? null : rs.getDate("consultation_date").toLocalDate(),
                    rs.getString("reason_for_visit"),
                    rs.getString("blood_pressure"),
                    (rs.getObject("temperature") == null) ? null : rs.getDouble("temperature"),
                    rs.getString("diagnosis"),
                    rs.getString("treatment"),
                    rs.getString("referral"),
                    (rs.getObject("systolic") == null) ? null : rs.getInt("systolic"),
                    (rs.getObject("diastolic") == null) ? null : rs.getInt("diastolic"),
                    rs.getString("bp_status"),
                    (rs.getObject("pulse_rate") == null) ? null : rs.getInt("pulse_rate"),
                    rs.getString("pulse_status"),
                    (rs.getObject("respiratory_rate") == null) ? null : rs.getInt("respiratory_rate"),
                    rs.getString("respiratory_status")
                );
                list.add(c);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    // ----------------------------- INSERT (simple, no meds) -----------------------------
    // Kept for compatibility; returns new id (used if you don't handle meds)
    public static int insert(Integer studentId, LocalDate cdate, String reason, String bp,
                             Double temp, String diagnosis, String treatment, String referral,
                             Integer pr, Integer rr) {
        String sql = "INSERT INTO consultations " +
                "(student_id, consultation_date, reason_for_visit, blood_pressure, temperature, " +
                " diagnosis, treatment, referral, pulse_rate, respiratory_rate) " +
                "VALUES (?,?,?,?,?,?,?,?,?,?)";
        try (Connection con = connect();
             PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

            ps.setInt(1, studentId);
            if (cdate == null) ps.setNull(2, Types.DATE); else ps.setDate(2, Date.valueOf(cdate));
            ps.setString(3, reason);
            ps.setString(4, bp);
            if (temp == null) ps.setNull(5, Types.DECIMAL); else ps.setBigDecimal(5, BigDecimal.valueOf(temp));
            ps.setString(6, diagnosis);
            ps.setString(7, treatment);
            ps.setString(8, referral);
            if (pr == null) ps.setNull(9, Types.INTEGER); else ps.setInt(9, pr);
            if (rr == null) ps.setNull(10, Types.INTEGER); else ps.setInt(10, rr);

            ps.executeUpdate();
            try (ResultSet rs = ps.getGeneratedKeys()) {
                if (rs.next()) return rs.getInt(1);
            }
        } catch (SQLException e) { e.printStackTrace(); }
        return -1;
    }

    // ----------------------------- INSERT with MEDS (transaction) -----------------------------
    public static int insertWithMeds(Integer studentId, LocalDate cdate, String reason, String bp,
                                     Double temp, String diagnosis, String treatment, String referral,
                                     Integer pr, Integer rr,
                                     List<RxRow> meds) throws StockException {
        String sqlIns = "INSERT INTO consultations " +
                "(student_id, consultation_date, reason_for_visit, blood_pressure, temperature, " +
                " diagnosis, treatment, referral, pulse_rate, respiratory_rate) " +
                "VALUES (?,?,?,?,?,?,?,?,?,?)";

        String sqlAddMed  = "INSERT INTO consultation_meds (consultation_id, item_id, qty) VALUES (?,?,?)";
        String sqlAddUsed = "UPDATE inventory SET total_used = COALESCE(total_used,0) + ? WHERE item_id=?";
        String sqlCheck   = "SELECT item_name, (quantity - COALESCE(total_used,0)) AS balance " +
                            "FROM inventory WHERE item_id=?";

        try (Connection con = connect()) {
            con.setAutoCommit(false);
            int newId;

            // ---- insert consultation master ----
            try (PreparedStatement ps = con.prepareStatement(sqlIns, Statement.RETURN_GENERATED_KEYS)) {
                ps.setInt(1, studentId);
                if (cdate == null) ps.setNull(2, Types.DATE); else ps.setDate(2, Date.valueOf(cdate));
                ps.setString(3, reason);
                ps.setString(4, bp);
                if (temp == null) ps.setNull(5, Types.DECIMAL); else ps.setBigDecimal(5, BigDecimal.valueOf(temp));
                ps.setString(6, diagnosis);
                ps.setString(7, treatment);
                ps.setString(8, referral);
                if (pr == null) ps.setNull(9, Types.INTEGER); else ps.setInt(9, pr);
                if (rr == null) ps.setNull(10, Types.INTEGER); else ps.setInt(10, rr);
                ps.executeUpdate();
                try (ResultSet rs = ps.getGeneratedKeys()) {
                    if (!rs.next()) throw new SQLException("No generated key");
                    newId = rs.getInt(1);
                }
            }

            // ---- meds + stock validation ----
            if (meds != null && !meds.isEmpty()) {
                try (PreparedStatement chk = con.prepareStatement(sqlCheck);
                     PreparedStatement ins = con.prepareStatement(sqlAddMed);
                     PreparedStatement upd = con.prepareStatement(sqlAddUsed)) {

                    for (RxRow r : meds) {
                        chk.setInt(1, r.getItemId());
                        try (ResultSet rs = chk.executeQuery()) {
                            if (!rs.next()) {
                                con.rollback();
                                throw new StockException("Unknown item (ID " + r.getItemId() + ")", 0, r.getQty());
                            }
                            String name = rs.getString("item_name");
                            int bal = rs.getInt("balance");
                            if (r.getQty() > bal || bal <= 0) {
                                con.rollback();
                                throw new StockException(name, bal, r.getQty());
                            }
                        }

                        ins.setInt(1, newId);
                        ins.setInt(2, r.getItemId());
                        ins.setInt(3, r.getQty());
                        ins.addBatch();

                        upd.setInt(1, r.getQty());
                        upd.setInt(2, r.getItemId());
                        upd.addBatch();
                    }
                    ins.executeBatch();
                    upd.executeBatch();
                }
            }

            con.commit();
            return newId;

        } catch (StockException se) {
            throw se; // handled by controller for friendly alert
        } catch (SQLException ex) {
            ex.printStackTrace(); // dev log
            return -1;
        }
    }


    // ----------------------------- UPDATE with MEDS (transaction) -----------------------------
    public static void updateWithMeds(int id, Integer studentId, LocalDate date, String reason, String bp,
                                      Double temp, String diagnosis, String treatment, String referral,
                                      Integer pulseRate, Integer respRate,
                                      List<RxRow> meds) throws StockException {
        String sqlUpd = """
            UPDATE consultations
               SET student_id=?, consultation_date=?, reason_for_visit=?, blood_pressure=?, temperature=?,
                   diagnosis=?, treatment=?, referral=?, pulse_rate=?, respiratory_rate=?
             WHERE consultation_id=?
        """;
        String sqlOld     = "SELECT item_id, qty FROM consultation_meds WHERE consultation_id=?";
        String sqlSubUsed = "UPDATE inventory SET total_used = COALESCE(total_used,0) - ? WHERE item_id=?";
        String sqlDel     = "DELETE FROM consultation_meds WHERE consultation_id=?";
        String sqlAddMed  = "INSERT INTO consultation_meds (consultation_id, item_id, qty) VALUES (?,?,?)";
        String sqlAddUsed = "UPDATE inventory SET total_used = COALESCE(total_used,0) + ? WHERE item_id=?";
        String sqlCheck   = "SELECT item_name, (quantity - COALESCE(total_used,0)) AS balance FROM inventory WHERE item_id=?";

        try (Connection con = connect()) {
            con.setAutoCommit(false);

            // ---- update master ----
            try (PreparedStatement ps = con.prepareStatement(sqlUpd)) {
                ps.setInt(1, studentId);
                ps.setDate(2, (date == null) ? null : Date.valueOf(date));
                ps.setString(3, reason);
                ps.setString(4, bp);
                if (temp == null) ps.setNull(5, Types.DECIMAL); else ps.setBigDecimal(5, BigDecimal.valueOf(temp));
                ps.setString(6, diagnosis);
                ps.setString(7, treatment);
                ps.setString(8, referral);
                if (pulseRate == null) ps.setNull(9, Types.INTEGER); else ps.setInt(9, pulseRate);
                if (respRate == null) ps.setNull(10, Types.INTEGER); else ps.setInt(10, respRate);
                ps.setInt(11, id);
                ps.executeUpdate();
            }

            // ---- restore previous inventory ----
            try (PreparedStatement sel = con.prepareStatement(sqlOld);
                 PreparedStatement sub = con.prepareStatement(sqlSubUsed)) {
                sel.setInt(1, id);
                try (ResultSet rs = sel.executeQuery()) {
                    while (rs.next()) {
                        sub.setInt(1, rs.getInt("qty"));
                        sub.setInt(2, rs.getInt("item_id"));
                        sub.addBatch();
                    }
                }
                sub.executeBatch();
            }

            // ---- clear old lines ----
            try (PreparedStatement del = con.prepareStatement(sqlDel)) {
                del.setInt(1, id);
                del.executeUpdate();
            }

            // ---- insert new meds + validate stock ----
            if (meds != null && !meds.isEmpty()) {
                try (PreparedStatement chk = con.prepareStatement(sqlCheck);
                     PreparedStatement ins = con.prepareStatement(sqlAddMed);
                     PreparedStatement add = con.prepareStatement(sqlAddUsed)) {

                    for (RxRow r : meds) {
                        chk.setInt(1, r.getItemId());
                        try (ResultSet rs = chk.executeQuery()) {
                            if (!rs.next()) {
                                con.rollback();
                                throw new StockException("Unknown item (ID " + r.getItemId() + ")", 0, r.getQty());
                            }
                            String name = rs.getString("item_name");
                            int bal = rs.getInt("balance");
                            if (r.getQty() > bal || bal <= 0) {
                                con.rollback();
                                throw new StockException(name, bal, r.getQty());
                            }
                        }

                        ins.setInt(1, id);
                        ins.setInt(2, r.getItemId());
                        ins.setInt(3, r.getQty());
                        ins.addBatch();

                        add.setInt(1, r.getQty());
                        add.setInt(2, r.getItemId());
                        add.addBatch();
                    }
                    ins.executeBatch();
                    add.executeBatch();
                }
            }

            con.commit();

        } catch (StockException se) {
            throw se;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    // ----------------------------- DELETE with MEDS (transaction) -----------------------------
    public static void deleteWithMeds(int id) {
        String sqlFetchLines = "SELECT item_id, qty FROM consultation_meds WHERE consultation_id=?";
        String sqlSubUsed    = "UPDATE inventory SET total_used = total_used - ? WHERE item_id=?";
        String sqlDelete     = "DELETE FROM consultations WHERE consultation_id=?"; // lines cascade

        try (Connection con = connect()) {
            con.setAutoCommit(false);

            // subtract usage first
            try (PreparedStatement sel = con.prepareStatement(sqlFetchLines);
                 PreparedStatement sub = con.prepareStatement(sqlSubUsed)) {
                sel.setInt(1, id);
                try (ResultSet rs = sel.executeQuery()) {
                    while (rs.next()) {
                        sub.setInt(1, rs.getInt("qty"));
                        sub.setInt(2, rs.getInt("item_id"));
                        sub.addBatch();
                    }
                }
                sub.executeBatch();
            }

            // delete master (will cascade lines)
            try (PreparedStatement del = con.prepareStatement(sqlDelete)) {
                del.setInt(1, id);
                del.executeUpdate();
            }

            con.commit();

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    // ----------------------------- Helpers -----------------------------
    private static Integer findBalance(int itemId, Connection con) {
        try (PreparedStatement ps = con.prepareStatement(
                "SELECT balance_stock FROM inventory WHERE item_id=?")) {
            ps.setInt(1, itemId);
            try (ResultSet rs = ps.executeQuery()) {
                return rs.next() ? (Integer) rs.getObject(1) : null;
            }
        } catch (SQLException e) { return null; }
    }
    
    // on viewing consultation (to show meds given)
    public static List<RxRow> findMedsByConsultationId(int consultationId) {
        List<RxRow> list = new ArrayList<>();
        String sql = """
            SELECT cm.item_id, cm.qty, i.item_name, i.unit
              FROM consultation_meds cm
              JOIN inventory i ON i.item_id = cm.item_id
             WHERE cm.consultation_id = ?
             ORDER BY i.item_name
        """;
        try (Connection con = MySQL.connect();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, consultationId);
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    int itemId    = rs.getInt("item_id");
                    int qty       = rs.getInt("qty");
                    String name   = rs.getString("item_name");
                    String unit   = rs.getString("unit");
                    list.add(new RxRow(itemId, name, unit, qty));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

}
