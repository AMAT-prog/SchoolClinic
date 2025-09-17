/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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
    
}

