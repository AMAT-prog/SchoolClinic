/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author User
 */

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDAO {

   public User findById(int id) {
        String sql = "SELECT user_id, username, first_name, last_name, contact_number, password, photo_path " +
                     "FROM users WHERE user_id=?";
        try (Connection c = MySQL.connect(); PreparedStatement ps = c.prepareStatement(sql)) {
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    User u = new User();
                    u.setUserId(rs.getInt("user_id"));
                    u.setUsername(rs.getString("username"));
                    u.setFirstName(rs.getString("first_name"));
                    u.setLastName(rs.getString("last_name"));
                    u.setContactNumber(rs.getString("contact_number"));
                    u.setPasswordHash(rs.getString("password"));
                    u.setPhotoPath(rs.getString("photo_path"));
                    return u;
                }
            }
        } catch (SQLException e) { e.printStackTrace(); }
        return null;
    }
   
    /** Profile save = first/last/contact/photo ONLY (no username here) */
    public boolean updateProfileNoUsername(int id, String first, String last, String contact, String photoPath) {
        String sql = "UPDATE users SET first_name=?, last_name=?, contact_number=?, photo_path=? WHERE user_id=?";
        try (Connection c = MySQL.connect(); PreparedStatement ps = c.prepareStatement(sql)) {
            ps.setString(1, first);
            ps.setString(2, last);
            ps.setString(3, contact);
            ps.setString(4, photoPath);
            ps.setInt(5, id);
//            return ps.executeUpdate() == 1;
        int rows = ps.executeUpdate();
        if (rows == 1) return true;

        // If 0 rows affected, print diagnostics:
        System.err.println("[UserDAO] Update returned 0 rows. user_id=" + id);
        return false;
            
        } catch (SQLException e) { e.printStackTrace(); return false; }
    }

    public String getPasswordHash(int id) {
        String sql = "SELECT password FROM users WHERE user_id=?";
        try (Connection c = MySQL.connect(); PreparedStatement ps = c.prepareStatement(sql)) {
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                return rs.next() ? rs.getString(1) : null;
            }
        } catch (SQLException e) { e.printStackTrace(); return null; }
    }
//
//    public boolean updatePassword(int id, String newHash) {
//        String sql = "UPDATE users SET password=? WHERE user_id=?";
//        try (Connection c = MySQL.connect(); PreparedStatement ps = c.prepareStatement(sql)) {
//            ps.setString(1, newHash);
//            ps.setInt(2, id);
//            return ps.executeUpdate() == 1;
//        } catch (SQLException e) { e.printStackTrace(); return false; }
//    }
    /** Change username and/or password (either can be null to skip) */
    public boolean updateCredentials(int id, String newUsernameOrNull, String newPasswordHashOrNull) {
        if ((newUsernameOrNull == null || newUsernameOrNull.isBlank()) &&
            (newPasswordHashOrNull == null || newPasswordHashOrNull.isBlank())) {
            return false; // nothing to update
        }
        StringBuilder sb = new StringBuilder("UPDATE users SET ");
        List<Object> params = new ArrayList<>();
        if (newUsernameOrNull != null && !newUsernameOrNull.isBlank()) {
            sb.append("username=?, ");
            params.add(newUsernameOrNull);
        }
        if (newPasswordHashOrNull != null && !newPasswordHashOrNull.isBlank()) {
            sb.append("password=?, ");
            params.add(newPasswordHashOrNull);
        }
        sb.setLength(sb.length() - 2); // trim last ", "
        sb.append(" WHERE user_id=?");
        params.add(id);

        try (Connection c = MySQL.connect(); PreparedStatement ps = c.prepareStatement(sb.toString())) {
            for (int i = 0; i < params.size(); i++) ps.setObject(i+1, params.get(i));
            return ps.executeUpdate() == 1;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
    
    // for login (used by AuthService.java class
     /** For login: fetch user by username */
    public User findByUsername(String username) {
        String sql = """
            SELECT user_id, username, first_name, last_name, contact_number, password, photo_path
            FROM users
            WHERE username = ?
            LIMIT 1
        """;
        try (Connection c = MySQL.connect(); PreparedStatement ps = c.prepareStatement(sql)) {
            ps.setString(1, username);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    User u = new User();
                    u.setUserId(rs.getInt("user_id"));
                    u.setUsername(rs.getString("username"));
                    u.setFirstName(rs.getString("first_name"));
                    u.setLastName(rs.getString("last_name"));
                    u.setContactNumber(rs.getString("contact_number"));
                    u.setPasswordHash(rs.getString("password")); // stored hash
                    u.setPhotoPath(rs.getString("photo_path"));
                    return u;
                }
            }
        } catch (SQLException e) { e.printStackTrace(); }
        return null;
    }

    /** Single-user convenience: return that user_id (first row) */
    
    public int getSingleUserId() {
        String sql = "SELECT user_id FROM users ORDER BY user_id LIMIT 1";
        try (Connection c = MySQL.connect(); Statement st = c.createStatement(); ResultSet rs = st.executeQuery(sql)) {
            return rs.next() ? rs.getInt(1) : 0;
        } catch (SQLException e) { e.printStackTrace(); return 0; }
    }

    /** Read the hashed recovery key (nullable) */
    public String getRecoveryKeyHash(int id) {
        String sql = "SELECT recovery_key_hash FROM users WHERE user_id=?";
        try (Connection c = MySQL.connect(); PreparedStatement ps = c.prepareStatement(sql)) {
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                return rs.next() ? rs.getString(1) : null;
            }
        } catch (SQLException e) { e.printStackTrace(); return null; }
    }
    
    public boolean updateRecoveryKeyHash(int id, String hash) {
        String sql = "UPDATE users SET recovery_key_hash=? WHERE user_id=?";
        try (Connection c = MySQL.connect(); PreparedStatement ps = c.prepareStatement(sql)) {
            ps.setString(1, hash);
            ps.setInt(2, id);
            return ps.executeUpdate() == 1;
        } catch (SQLException e) { e.printStackTrace(); return false; }
    }

}
