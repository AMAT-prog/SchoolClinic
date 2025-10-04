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
import java.util.ArrayList;
import java.util.Collections;
import java.util.EnumSet;
import java.util.List;
//import java.time.*;
//import java.util.*;

public class CalendarDao {

    private final Connection conn;

    public CalendarDao(Connection conn) { this.conn = conn; }
   

    public List<CalendarItem> findBetween(LocalDate start, LocalDate end,
                                      EnumSet<CalendarItem.Kind> kinds) throws SQLException {
        boolean filterKinds = kinds != null && kinds.size() > 0
                && kinds.size() < CalendarItem.Kind.values().length;

        String placeholders = filterKinds
                ? String.join(",", Collections.nCopies(kinds.size(), "?"))
                : "";

        String sql =
            "SELECT `calendar_id`,`title`,`description`,`kind`,`status`,`start_date`,`start_time`,`all_day`,`reminder_at` " +
            "FROM `calendar_item` " +
            "WHERE `start_date` BETWEEN ? AND ? " +
            (filterKinds ? ("AND `kind` IN (" + placeholders + ") ") : "") +
            // ---- fixed ORDER BY ----
            "ORDER BY `all_day` DESC, " +
            "         CASE WHEN `start_time` IS NULL THEN 1 ELSE 0 END, " +
            "         `start_time` ASC, `title` ASC";

        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            int i = 1;
            ps.setDate(i++, Date.valueOf(start));
            ps.setDate(i++, Date.valueOf(end));
            if (filterKinds) {
                for (CalendarItem.Kind k : kinds) ps.setString(i++, k.name());
            }
            try (ResultSet rs = ps.executeQuery()) {
                List<CalendarItem> out = new ArrayList<>();
                while (rs.next()) out.add(map(rs));
                return out;
            }
        }
    }


    public List<CalendarItem> findUpcoming(int limit) throws SQLException {
        String sql = "SELECT * FROM calendar_item WHERE start_date >= CURDATE() ORDER BY start_date, start_time LIMIT ?";
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, Math.max(1, limit));
            try (ResultSet rs = ps.executeQuery()) {
                List<CalendarItem> list = new ArrayList<>();
                while (rs.next()) list.add(map(rs));
                return list;
            }
        }
    }

    public List<CalendarItem> remindersDueToday() throws SQLException {
        String sql = "SELECT * FROM calendar_item WHERE reminder_at IS NOT NULL " +
                     "AND DATE(reminder_at) = CURDATE() ORDER BY reminder_at";
        try (PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            List<CalendarItem> list = new ArrayList<>();
            while (rs.next()) list.add(map(rs));
            return list;
        }
    }

    public int insert(CalendarItem c) throws SQLException {
        String sql = "INSERT INTO calendar_item (title, description, kind, status, start_date, start_time, all_day, reminder_at) " +
                     "VALUES (?,?,?,?,?,?,?,?)";
        try (PreparedStatement ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            bind(ps, c);
            ps.executeUpdate();
            try (ResultSet g = ps.getGeneratedKeys()) {
                if (g.next()) return g.getInt(1);
            }
            return -1;
        }
    }

    public void update(CalendarItem c) throws SQLException {
        String sql = "UPDATE calendar_item SET title=?, description=?, kind=?, status=?, start_date=?, start_time=?, all_day=?, reminder_at=? " +
                     "WHERE calendar_id=?";
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            bind(ps, c);
            ps.setInt(9, c.getCalendarId());
            ps.executeUpdate();
        }
    }

    public void delete(int id) throws SQLException {
        try (PreparedStatement ps = conn.prepareStatement("DELETE FROM calendar_item WHERE calendar_id=?")) {
            ps.setInt(1, id);
            ps.executeUpdate();
        }
    }

    public void markDone(int id, boolean done) throws SQLException {
        try (PreparedStatement ps = conn.prepareStatement("UPDATE calendar_item SET status=? WHERE calendar_id=?")) {
            ps.setString(1, done ? CalendarItem.Status.done.name() : CalendarItem.Status.pending.name());
            ps.setInt(2, id);
            ps.executeUpdate();
        }
    }

    // -------- helpers --------
    private CalendarItem map(ResultSet rs) throws SQLException {
        CalendarItem c = new CalendarItem();
        c.setCalendarId(rs.getInt("calendar_id"));
        c.setTitle(rs.getString("title"));
        c.setDescription(rs.getString("description"));
        c.setKind(CalendarItem.Kind.valueOf(rs.getString("kind")));
        c.setStatus(CalendarItem.Status.valueOf(rs.getString("status")));
        c.setStartDate(rs.getDate("start_date").toLocalDate());
        Time t = rs.getTime("start_time");
        c.setStartTime(t != null ? t.toLocalTime() : null);
        c.setAllDay(rs.getBoolean("all_day"));
        Timestamp rem = rs.getTimestamp("reminder_at");
        c.setReminderAt(rem != null ? rem.toLocalDateTime() : null);
        return c;
    }

    private void bind(PreparedStatement ps, CalendarItem c) throws SQLException {
        int i = 1;
        ps.setString(i++, c.getTitle());
        ps.setString(i++, c.getDescription());
        ps.setString(i++, c.getKind().name());
        ps.setString(i++, c.getStatus().name());
        ps.setDate(i++, Date.valueOf(c.getStartDate()));
        if (c.getStartTime() != null) ps.setTime(i++, Time.valueOf(c.getStartTime()));
        else ps.setNull(i++, Types.TIME);
        ps.setBoolean(i++, c.isAllDay());
        if (c.getReminderAt() != null) ps.setTimestamp(i++, Timestamp.valueOf(c.getReminderAt()));
        else ps.setNull(i++, Types.TIMESTAMP);
    }
}
