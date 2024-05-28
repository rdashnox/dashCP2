/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.home;



import com.databaseCon.MotorPH_DB;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author hp
 */
public class Bal_DA {
    
    
    
 
   
   
    public List<Bean_AL> loadDataA() {
        List<Bean_AL> list = new ArrayList<Bean_AL>();
        try {
            String query = "select * from motorphdb"; 
            PreparedStatement ps = MotorPH_DB.con.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
                        while (rs.next()) {                
                int id = rs.getInt("ID");
                String lastName = rs.getString("Last Name");
                String firstName = rs.getString("First Name");
                String riceAl = rs.getString("Rice Subsidy");
                String phoneAl = rs.getString("Phone Allowance");
                String clothAl = rs.getString("Clothing Allowance");
               
               
                
                Bean_AL bean = new Bean_AL(id, lastName, firstName, riceAl, phoneAl, clothAl);
                list.add(bean);
                
            }
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, ""+e);
        }
        return list;
    }
    
      
    
    
    
   public List<Bean_AL> searchEmployeeA(String keyword) {
        List<Bean_AL> list = new ArrayList<>();
        try {
            String query = "SELECT * FROM motorphdb WHERE ID = ? OR `Last Name` LIKE ? OR `First Name` LIKE ?";
            PreparedStatement ps = MotorPH_DB.con.prepareStatement(query);
            ps.setString(1, keyword);
            ps.setString(2, "%" + keyword + "%");
            ps.setString(3, "%" + keyword + "%");
            ResultSet rs = ps.executeQuery();
            
            while (rs.next()) {
                int id = rs.getInt("ID");
                String lastName = rs.getString("Last Name");
                String firstName = rs.getString("First Name");
                String riceAl = rs.getString("Rice Subsidy");
                String phoneAl = rs.getString("Phone Allowance");
                String clothAl = rs.getString("Clothing Allowance");

               Bean_AL bean = new Bean_AL(id, lastName, firstName, riceAl, phoneAl, clothAl);
                list.add(bean);
                
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error searching employees: " + e.getMessage());
        }
        return list;
    } 
   
    
}
