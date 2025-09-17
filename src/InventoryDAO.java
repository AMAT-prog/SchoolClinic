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

public class InventoryDAO {

    public static ObservableList<Inventory> findAll() {
        ObservableList<Inventory> list = FXCollections.observableArrayList();
        String sql = """
            SELECT item_id, item_name, type, quantity, unit, expiry_date, status
            FROM inventory
            ORDER BY item_name ASC
        """;
        try (Connection con = MySQL.connect();
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                int id = rs.getInt("item_id");
                String name = rs.getString("item_name");
                String type = rs.getString("type");
                int qty = rs.getInt("quantity");
                String unit = rs.getString("unit");
                Date d = rs.getDate("expiry_date");
                LocalDate expiry = (d != null) ? d.toLocalDate() : null;
                String status = rs.getString("status");

                list.add(new Inventory(id, name, type, qty, unit, expiry, status));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    public static boolean deleteById(int itemId) {
        String sql = "DELETE FROM inventory WHERE item_id = ?";
        try (Connection con = MySQL.connect();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, itemId);
            return ps.executeUpdate() == 1;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    // update stub (wire to Edit dialog)
    public static boolean update(Inventory inv) {
        String sql = """
            UPDATE inventory
               SET item_name=?, type=?, quantity=?, unit=?, expiry_date=?, status=?
             WHERE item_id=?
        """;
        try (Connection con = MySQL.connect();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, inv.getItemName());
            ps.setString(2, inv.getType());
            ps.setInt(3, inv.getQuantity());
            ps.setString(4, inv.getUnit());
            if (inv.getExpiryDate() != null) {
                ps.setDate(5, Date.valueOf(inv.getExpiryDate()));
            } else {
                ps.setNull(5, Types.DATE);
            }
            ps.setString(6, inv.getStatus());
            ps.setInt(7, inv.getItemId());
            return ps.executeUpdate() == 1;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
    
    // InventoryADD/EDIT
    public static int insert(Inventory inv) {
        String sql = "INSERT INTO inventory (item_name, type, quantity, unit, expiry_date, status) " +
                     "VALUES (?,?,?,?,?,?)";
        try (Connection con = MySQL.connect();
             PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

            ps.setString(1, inv.getItemName());
            ps.setString(2, inv.getType());
            ps.setInt(3, inv.getQuantity());
            ps.setString(4, inv.getUnit());
            if (inv.getExpiryDate() != null) {
                ps.setDate(5, Date.valueOf(inv.getExpiryDate()));
            } else {
                ps.setNull(5, Types.DATE);
            }
            ps.setString(6, inv.getStatus());

            int rows = ps.executeUpdate();
            if (rows == 1) {
                try (ResultSet rs = ps.getGeneratedKeys()) {
                    if (rs.next()) return rs.getInt(1);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return -1; // failed
    }
    
    public static int countItems() {
        final String sql = "SELECT COUNT(*) FROM inventory";
        try (Connection con = MySQL.connect();
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            return rs.next() ? rs.getInt(1) : 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return 0;
        }
}


}

