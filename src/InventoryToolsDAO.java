/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author User
 */
// InventoryToolsDAO.java
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import java.sql.*;
import java.time.LocalDate;
import java.math.BigDecimal;

public class InventoryToolsDAO {

    private static Connection connect() throws SQLException {
        return MySQL.connect(); 
    }

    public static ObservableList<InventoryTool> findAll() {
        ObservableList<InventoryTool> list = FXCollections.observableArrayList();
        String sql = """
            SELECT tool_id, tool_code, item_name, category, quantity, unit, location,
                   status, remarks, acquired_on, purchase_cost
              FROM inventory_tools
             ORDER BY item_name ASC
        """;
        try (Connection con = connect();
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                int id = rs.getInt("tool_id");
                String code = rs.getString("tool_code");
                String name = rs.getString("item_name");
                String cat  = rs.getString("category");
                int qty     = rs.getInt("quantity");
                String unit = rs.getString("unit");
                String loc  = rs.getString("location");
                String st   = rs.getString("status");
                String rem  = rs.getString("remarks");
                Date d      = rs.getDate("acquired_on");
                LocalDate acq = d != null ? d.toLocalDate() : null;
                BigDecimal cost = rs.getBigDecimal("purchase_cost");

                list.add(new InventoryTool(id, code, name, cat, qty, unit, loc, st, rem, acq, cost));
            }
        } catch (SQLException e) { e.printStackTrace(); }
        return list;
    }

    public static boolean deleteById(int toolId) {
        String sql = "DELETE FROM inventory_tools WHERE tool_id=?";
        try (Connection con = connect(); PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, toolId);
            return ps.executeUpdate() == 1;
        } catch (SQLException e) { e.printStackTrace(); return false; }
    }

    // For future Edit/View dialog
    public static boolean update(InventoryTool t) {
        String sql = """
            UPDATE inventory_tools
               SET tool_code=?, item_name=?, category=?, quantity=?, unit=?, location=?,
                   status=?, remarks=?, acquired_on=?, purchase_cost=?
             WHERE tool_id=?
        """;
        try (Connection con = connect(); PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, t.getToolCode());
            ps.setString(2, t.getItemName());
            ps.setString(3, t.getCategory());
            ps.setInt(4, t.getQuantity());
            ps.setString(5, t.getUnit());
            ps.setString(6, t.getLocation());
            ps.setString(7, t.getStatus());
            ps.setString(8, t.getRemarks());
            if (t.getAcquiredOn() != null) ps.setDate(9, Date.valueOf(t.getAcquiredOn())); else ps.setNull(9, Types.DATE);
            if (t.getPurchaseCost() != null) ps.setBigDecimal(10, t.getPurchaseCost()); else ps.setNull(10, Types.DECIMAL);
            ps.setInt(11, t.getToolId());
            return ps.executeUpdate() == 1;
        } catch (SQLException e) { e.printStackTrace(); return false; }
    }
    
    public static int insert(InventoryTool t) {
        String sql = """
            INSERT INTO inventory_tools 
            (tool_code, item_name, category, quantity, unit, location, status, remarks, acquired_on, purchase_cost)
            VALUES (?,?,?,?,?,?,?,?,?,?)
        """;

        try (Connection con = MySQL.connect();
             PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

            ps.setString(1, t.getToolCode());
            ps.setString(2, t.getItemName());
            ps.setString(3, t.getCategory());
            ps.setInt(4, t.getQuantity());
            ps.setString(5, t.getUnit());
            ps.setString(6, t.getLocation());
            ps.setString(7, t.getStatus());
            ps.setString(8, t.getRemarks());
            if (t.getAcquiredOn() != null)
                ps.setDate(9, Date.valueOf(t.getAcquiredOn()));
            else
                ps.setNull(9, Types.DATE);

            if (t.getPurchaseCost() != null)
                ps.setBigDecimal(10, t.getPurchaseCost());
            else
                ps.setNull(10, Types.DECIMAL);

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

}
