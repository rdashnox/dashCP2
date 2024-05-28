/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.databaseCon;

import com.home.Bal;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.util.Date;
import javax.swing.JOptionPane;

/**
 *
 * @author hp
 */
public class MotorPH_DBAtt {
    public static Connection con = null;

    public static void loadConnection() {
        String url = "jdbc:mysql://localhost:3306/emp_msdb";
        String root = "root";
        String pass = "mYSQLDASH/4*";

        try {
            con = DriverManager.getConnection(url, root, pass);

            if (con != null) {
                
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error in Database" + e);
        }
    }

    public static void saveTimeInToDatabase(Date dateString, Time time) {
        
        try {
        loadConnection();
        int id = Bal.AdID;
        String query = "INSERT INTO attendance (AttID, ID, LogDate, LogTime, Status) VALUES (NULL, ?, ?, ?, ?)";
        PreparedStatement ps = con.prepareStatement(query);
        ps.setInt(1, id); // Assuming ID is an integer
         ps.setDate(2, new java.sql.Date(dateString.getTime()));
        ps.setTime(3, time);// Assuming LogDate is a string
        ps.setString(4, "Logged in"); // Assuming Status is a string
        ps.executeUpdate();
        ps.close();
        JOptionPane.showMessageDialog(null, "Check-IN time saved successfully!");
    } catch (SQLException e) {
        JOptionPane.showMessageDialog(null, "Error in saving Check-IN time: " + e.getMessage());
    }
        
    }
    public static void saveTimeOutToDatabase(Date dateString, Time time) {
        
        try {
        loadConnection();
        int id = Bal.AdID;
        String query = "INSERT INTO attendance (AttID, ID, LogDate, LogTime, Status) VALUES (NULL, ?, ?, ?, ?)";
        PreparedStatement ps = con.prepareStatement(query);
        ps.setInt(1, id); // Assuming ID is an integer
         ps.setDate(2, new java.sql.Date(dateString.getTime()));
        ps.setTime(3, time);// Assuming LogDate is a string
        ps.setString(4, "Logged out"); // Assuming Status is a string
        ps.executeUpdate();
        ps.close();
        JOptionPane.showMessageDialog(null, "Check-OUT time saved successfully!");
    } catch (SQLException e) {
        JOptionPane.showMessageDialog(null, "Error in saving Check-OUT time: " + e.getMessage());
    }
}

    public static boolean hasCheckedIn(int value, Date dateString, Time timeString) {
        try {
        loadConnection();
        String query = "SELECT COUNT(*) FROM attendance WHERE ID = ? AND LogDate = ? AND LogTime = ?";
        PreparedStatement ps = con.prepareStatement(query);
        ps.setInt(1, Bal.AdID);
         ps.setDate(2, new java.sql.Date(dateString.getTime()));
         ps.setTime(3, timeString);
        ResultSet rs = ps.executeQuery();
        if (rs.next()) {
            int count = rs.getInt(1);
            return count > 0;
        }
    } catch (SQLException e) {
        JOptionPane.showMessageDialog(null, "Error in checking Check-IN status: " + e.getMessage());
    }
    return false;
    }
public static boolean hasCheckedOut(int value, Date dateString, Time timeString) {
        try {
        loadConnection();
        String query = "SELECT COUNT(*) FROM attendance WHERE ID = ? AND LogDate = ? AND LogTime = ?";
        PreparedStatement ps = con.prepareStatement(query);
        ps.setInt(1, Bal.AdID);
        ps.setDate(2, new java.sql.Date(dateString.getTime()));
        ps.setTime(3, timeString);
        ResultSet rs = ps.executeQuery();
        if (rs.next()) {
            int count = rs.getInt(1);
            return count > 0;
        }
    } catch (SQLException e) {
        JOptionPane.showMessageDialog(null, "Error in checking Check-OUT status: " + e.getMessage());
    }
    return false;
    }
}
