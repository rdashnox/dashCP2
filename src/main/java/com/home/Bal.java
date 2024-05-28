/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.home;

import com.databaseCon.MotorPH_DB;
import java.awt.HeadlessException;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

/**
 *
 * @author hp
 */
public class Bal {
    MotorPH_String searchQuery = new MotorPH_String();
    public static int EmpID;
    public static String EmpFirstName;
    public static String EmpLastName;
    public static Date EmpBirthday;
    public static String EmpEmail;
    public static int AdID;
    public static String AdFirstName;
    public static String AdLastName;
    public static Date AdBirthday;
    public static String AdEmail;
    
    
    
    public List<Bean> loadData() {
        List<Bean> list = new ArrayList<>();
        try {PreparedStatement ps = MotorPH_DB.con.prepareStatement(searchQuery.loadData);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
            list.add(new Bean(
                rs.getInt(Integer.parseInt(searchQuery.id)),
                rs.getString(searchQuery.lastName),
                rs.getString(searchQuery.firstName),
                rs.getDate(searchQuery.birthDay),
                rs.getString(searchQuery.email),
                rs.getString(searchQuery.passWord),
                rs.getString(searchQuery.designation)
            ));
        }
    } catch (SQLException e) {
        JOptionPane.showMessageDialog(null, "" + e);
    }
    return list;
    }
    
    public void insertDataAddEmp(Bean bean){
        try {PreparedStatement ps = MotorPH_DB.con.prepareStatement(searchQuery.insertDataAddEmp);
                ps.setString(1, bean.getLastName());
                ps.setString(2, bean.getFirstName());
                ps.setObject(3, bean.getBirthday());
                ps.setString(4, bean.getEmail());
                ps.setString(5, bean.getPassword());
                ps.setString(6, bean.getDesignation());

                ps.executeUpdate();
                JOptionPane.showMessageDialog(null, "Employee Successfully Added");
    } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "" + e);
        }
    }
    
    public Bean returnAllDataToTextField (int id){
        Bean bean = null;
        try (PreparedStatement ps = MotorPH_DB.con.prepareStatement("select * from motorphdb where ID = "+id)) {
                ps.setInt(1, id);
        try (ResultSet rs = ps.executeQuery()) {
            if (rs.next()) {
                bean = new Bean(
                rs.getInt(Integer.parseInt(searchQuery.id)),
                rs.getString(searchQuery.lastName),
                rs.getString(searchQuery.firstName),
                rs.getDate(searchQuery.birthDay),
                rs.getString(searchQuery.email),
                rs.getString(searchQuery.passWord),
                rs.getString(searchQuery.designation)
                );
                }
            }
        }catch (SQLException e) {
        // handle the exception
    }
    return bean;
}
    
    public void updateBirthday(Bean bean){
        try {PreparedStatement ps = MotorPH_DB.con.prepareStatement(searchQuery.updateBirthday);
                ps.setString(1, bean.getLastName());
                ps.setString(2, bean.getFirstName());
                ps.setObject(3,bean.getBirthday());
                ps.setString(4, bean.getEmail());
                ps.setString(5, bean.getPassword());
                ps.setString(6, bean.getDesignation());
                ps.setInt(7, bean.getId());
            
                ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Record has been updated");
            
        }catch (HeadlessException | SQLException e) {
            JOptionPane.showMessageDialog(null, ""+e);
        }
    }

    public List<Bean> searchEmployee(String keyword) {
        Bean bean = null;
        List<Bean> list = new ArrayList<>();
        try {PreparedStatement ps = MotorPH_DB.con.prepareStatement(searchQuery.searchEmployee);
                ps.setString(1, keyword);
                ps.setString(2, "%" + keyword + "%");
                ps.setString(3, "%" + keyword + "%");
                ResultSet rs = ps.executeQuery();
            
        while (rs.next()) {
                list.add(new Bean(
                rs.getInt(Integer.parseInt(searchQuery.id)),
                rs.getString(searchQuery.lastName),
                rs.getString(searchQuery.firstName),
                rs.getDate(searchQuery.birthDay),
                rs.getString(searchQuery.email),
                rs.getString(searchQuery.passWord),
                rs.getString(searchQuery.designation)
                ));
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error searching employees: " + e.getMessage());
    }
        return (List<Bean>) bean;
}

 public void displayEmployeeInfo(JLabel jLabel53SSSN, JLabel jLabel5PHN, JLabel jLabel55PN, JLabel jLabel45TINN) {
        try {PreparedStatement ps = MotorPH_DB.con.prepareStatement(searchQuery.displayEmployeeInfo);
            // Query to retrieve specific columns based on EmpID
            ps.setInt(1, EmpID); // Assuming EmpID is accessible from this class
            
            ResultSet rs = ps.executeQuery();
            
            // Check if there is a result
            if (rs.next()) {
                // Update JLabels with retrieved values
                jLabel53SSSN.setText(rs.getString("SSS #"));
                jLabel5PHN.setText(rs.getString("Philhealth #"));
                jLabel55PN.setText(rs.getString("Pag-ibig #"));
                jLabel45TINN.setText(rs.getString("TIN #"));
            }
        } catch (SQLException e) {
    }
}
   
    
    
}
