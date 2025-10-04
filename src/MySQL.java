/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class MySQL {
    public static Connection conn = null;
    public static  PreparedStatement pst,pst1;
    public static ResultSet rs,rs1;

    public static Connection connect() {
        try{
       Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/school_clinic_db", "root", "root");
           // JOptionPane.showMessageDialog(null,"Connection Established!");
            return conn;
        } 
        catch (Exception e){
                JOptionPane.showMessageDialog(null,e);
                return null;
        }
    }
    
        public static List<Student1> findStudents(String query){
           List<Student1> list = new ArrayList<>();
           String sql = "SELECT student_id, first_name, last_name, COALESCE(middle_name,'') mi " +
                        "FROM students WHERE (? IS NULL OR id_number LIKE CONCAT('%',?,'%') " +
                        "OR first_name LIKE CONCAT('%',?,'%') OR last_name LIKE CONCAT('%',?,'%')) " +
                        "ORDER BY last_name LIMIT 20";
           try (Connection con = connect(); PreparedStatement ps = con.prepareStatement(sql)){
               String k = (query==null || query.trim().isEmpty()) ? null : query.trim();
               for (int i=1;i<=4;i++) ps.setString(i, k);
               try (ResultSet rs = ps.executeQuery()){
                   while (rs.next())
                       list.add(new Student1(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4)));
               }
           } catch (SQLException e){ e.printStackTrace(); }
           return list;
       }
    
        public static void insertAudit(Connection con, int certId, String action, String reason) {
            
            try (PreparedStatement ps = con.prepareStatement(
                    "INSERT INTO medcert_audit (cert_id, action, reason) VALUES (?, ?, ?)")) {
                ps.setInt(1, certId);
                ps.setString(2, action);
                ps.setString(3, reason);
                ps.executeUpdate();
            } catch (SQLException ignore) {
                // Optional: log it somewhere; we swallow so it doesn't break deletes
            }
        }
    
}

