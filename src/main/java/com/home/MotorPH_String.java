/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.home;

/**
 *
 * @author CHAS
 */
public class MotorPH_String {
    //Queries
    String loadData = "select * from motorphdb";
    String insertDataAddEmp = "INSERT INTO motorphdb (`Last Name`, `First Name`, Birthday, Email, Password, Designation) VALUES (?, ?, ?, ?, ?, ?)";
    String returnAllDataToTextField = "update motorphdb set `Last Name` = ?, `First Name` = ?, Birthday = ?, Email = ?, Password = ?, Designation = ? WHERE ID = ?";
    String updateBirthday = "update motorphdb set `Last Name` = ?, `First Name` = ?, Birthday = ?, Email = ?, Password = ?, Designation = ? WHERE ID = ?";
    String searchEmployee = "SELECT * FROM motorphdb WHERE ID = ? OR `Last Name` LIKE ? OR `First Name` LIKE ?";
    String displayEmployeeInfo = "SELECT `SSS #`, `Philhealth #`, `Pag-ibig #`, `TIN #` FROM motorphdb WHERE ID = ?";
    
      
    
    
    
    
    
    //Strings
    String id = "ID";
    String lastName = "Last Name";
    String firstName = "First Name";
    String birthDay  = "Birthday";
    String email = "Email";
    String passWord = "Password";
    String designation = "Designation";
    String SSS = "SSS #";
    String philHealth = "Philhealth #";
    String pagIbig = "Pag-ibig #";
    String tin = "TIN #";
    String logDate = "LogDate";
    String logTime = "LogTime";
    String status = "Status";
    
}