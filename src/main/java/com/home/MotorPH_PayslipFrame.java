/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.home;

import com.databaseCon.MotorPH_DB;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JComboBox;
import javax.swing.JLabel;

/**
 *
 * @author hp
 */
public class MotorPH_PayslipFrame extends javax.swing.JFrame {

    /**
     * Creates new form MotorPH_PayslipFrame
     */
    public MotorPH_PayslipFrame() {
        initComponents();
         jLabelEmpfistName.setText(String.valueOf(Bal.EmpFirstName).toString());
        jLabelEmplastName.setText(String.valueOf(Bal.EmpLastName ).toString());
        
        Bal bal =  new Bal();
        bal.displayEmployeeInfo(jLabel53SSSN, jLabel5PHN, jLabel55PN, jLabel45TINN);
        
        
        
    }

    public void displayTotalAllowances(JComboBox<String> jComboBox4Year, JComboBox<String> jComboBox2Month,
            JComboBox<String> jComboBox1Term, JLabel jLabel47AL) {

        // Get selected values from JComboBoxes
        String selectedYear = jComboBox4Year.getSelectedItem().toString();
        String selectedMonth = jComboBox2Month.getSelectedItem().toString();
        String selectedTerm = jComboBox1Term.getSelectedItem().toString();

        // Build SQL query
        String query = "SELECT `Total Allowances` FROM payroll WHERE DATE LIKE ? AND Term = ? AND EmpID = ?";

        try {
            // Prepare and execute SQL query
            Connection con = MotorPH_DB.con; // Assuming MotorPH_DB.con is your database connection
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, "%" + selectedYear + "-" + selectedMonth + "%");
            ps.setString(2, selectedTerm);
            ps.setInt(3, Bal.EmpID); // Assuming Bal.EmpID holds the ID of the employee
            ResultSet rs = ps.executeQuery();

            // Check if result set has data
            if (rs.next()) {
                // Display total allowances on jLabel47AL
                String totalAllowances = rs.getString("Total Allowances");
                jLabel47AL.setText(totalAllowances);
            } else {
                // No data found for selected criteria
                jLabel47AL.setText("0.00");
            }

        } catch (Exception e) {
            // Handle any exceptions
            e.printStackTrace(); // You can change this to appropriate error handling
        }
    }

    
    
    
    
    
    
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jButton4 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jPanel6 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jLabel19 = new javax.swing.JLabel();
        jLabelEmpName = new javax.swing.JLabel();
        jLabelEmplastName = new javax.swing.JLabel();
        jLabelEmpfistName = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jComboBox1Term = new javax.swing.JComboBox<>();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jComboBox2Month = new javax.swing.JComboBox<>();
        jComboBox3 = new javax.swing.JComboBox<>();
        jComboBox4Year = new javax.swing.JComboBox<>();
        jComboBox5 = new javax.swing.JComboBox<>();
        jPanel3 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel9PD = new javax.swing.JLabel();
        jLabel10BD = new javax.swing.JLabel();
        jLabel15ED = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jLabel52 = new javax.swing.JLabel();
        jLabel58 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        jLabel32 = new javax.swing.JLabel();
        jLabel33 = new javax.swing.JLabel();
        jLabel34 = new javax.swing.JLabel();
        jLabel35 = new javax.swing.JLabel();
        jLabel36 = new javax.swing.JLabel();
        jLabel37 = new javax.swing.JLabel();
        jLabel38 = new javax.swing.JLabel();
        jLabel40 = new javax.swing.JLabel();
        jLabel41 = new javax.swing.JLabel();
        jLabel42 = new javax.swing.JLabel();
        jLabel43 = new javax.swing.JLabel();
        jLabel44 = new javax.swing.JLabel();
        jLabel45TINN = new javax.swing.JLabel();
        jLabel47AL = new javax.swing.JLabel();
        jLabel49 = new javax.swing.JLabel();
        jLabel50 = new javax.swing.JLabel();
        jLabel51 = new javax.swing.JLabel();
        jLabel53SSSN = new javax.swing.JLabel();
        jLabel5PHN = new javax.swing.JLabel();
        jLabel55PN = new javax.swing.JLabel();
        jLabel56 = new javax.swing.JLabel();
        jLabel57 = new javax.swing.JLabel();
        jLabel48 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(0, 0, 0));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 250, 80));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1024, 100));

        jButton4.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButton4.setText("Home");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 100, 260, 40));

        jButton3.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButton3.setText("Employee Information");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 100, 260, 40));

        jButton5.setBackground(new java.awt.Color(153, 153, 153));
        jButton5.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButton5.setForeground(new java.awt.Color(255, 255, 255));
        jButton5.setText("Payslip");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton5, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 100, 260, 40));

        jButton6.setBackground(new java.awt.Color(204, 0, 0));
        jButton6.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButton6.setForeground(new java.awt.Color(255, 255, 255));
        jButton6.setText("Logout");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton6, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 100, 250, 40));

        jPanel6.setBackground(new java.awt.Color(0, 0, 0));
        jPanel6.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel11.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("Group 1");
        jPanel6.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(970, 30, -1, 20));

        jLabel12.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("Office Address: 5th Flr., The World Center #330 Sen. Gil Puyat Ave., Makati City, Manila, Philippines");
        jPanel6.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 30, -1, 20));

        jLabel13.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setText("Office Phone Number: +63-2-754-7000");
        jPanel6.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 50, -1, 20));

        jLabel14.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setText("Office Email: support@motorph.com");
        jPanel6.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 70, -1, 20));

        jLabel16.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(255, 255, 255));
        jLabel16.setText("Office Hours: 8:00AM - 5:00PM");
        jPanel6.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, -1, 20));

        jLabel18.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(255, 255, 255));
        jLabel18.setText("MO-IT103 - Computer Programming 2");
        jPanel6.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 70, -1, 20));

        jLabel20.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(255, 255, 255));
        jPanel6.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(870, 10, -1, 20));

        jLabel21.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(255, 255, 255));
        jLabel21.setText("Section : A1101");
        jPanel6.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(930, 50, -1, 20));

        jPanel1.add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 670, 1024, 100));

        jPanel5.setBackground(new java.awt.Color(204, 204, 204));
        jPanel5.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(153, 153, 153), 2, true));
        jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel5.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 30, 150, 150));

        jLabelEmpName.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        jLabelEmpName.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelEmpName.setText("Welcome!");
        jPanel5.add(jLabelEmpName, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 170, 260, 60));

        jLabelEmplastName.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabelEmplastName.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelEmplastName.setText("jLabel18");
        jLabelEmplastName.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jPanel5.add(jLabelEmplastName, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 240, 260, 60));

        jLabelEmpfistName.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabelEmpfistName.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelEmpfistName.setText("jLabel18");
        jLabelEmpfistName.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jPanel5.add(jLabelEmpfistName, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 220, 260, 60));

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("Employee");
        jPanel5.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 210, 260, -1));

        jPanel1.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 140, 260, 530));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel5.setText("Month :");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 160, -1, -1));

        jComboBox1Term.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Term 1 (Month Day: 1st day until 15th)", "Term 2 (Month Day:16th day until last day)" }));
        jPanel1.add(jComboBox1Term, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 160, 240, -1));

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel7.setText("Term :");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 160, -1, -1));

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel8.setText("Year :");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 160, -1, -1));

        jComboBox2Month.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "January", "Febuary", "March", "Apil. May", "June", "July", "August", "September", "October", "November", "December" }));
        jPanel1.add(jComboBox2Month, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 160, 100, -1));

        jComboBox3.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jPanel1.add(jComboBox3, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 160, 100, -1));

        jComboBox4Year.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "2024", "2023", "2022" }));
        jPanel1.add(jComboBox4Year, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 160, 100, -1));

        jComboBox5.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jPanel1.add(jComboBox5, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 160, 100, -1));

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setText("Pay Day :");
        jPanel3.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 10, -1, -1));

        jLabel4.setText("End Date :");
        jPanel3.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 10, -1, -1));

        jLabel9PD.setText("jLabel9");
        jPanel3.add(jLabel9PD, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 10, 140, -1));

        jLabel10BD.setText("jLabel9");
        jPanel3.add(jLabel10BD, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 10, 140, -1));

        jLabel15ED.setText("jLabel9");
        jPanel3.add(jLabel15ED, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 10, 140, -1));

        jPanel4.setBackground(new java.awt.Color(0, 0, 0));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Deductions :");
        jPanel4.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 10, 100, -1));

        jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Earnings :");
        jPanel4.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 80, -1));

        jPanel3.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 40, 690, 40));

        jLabel15.setText("Begin Date :");
        jPanel3.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, -1, -1));

        jLabel17.setText("Allowances");
        jPanel3.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 90, -1, -1));

        jPanel7.setBackground(new java.awt.Color(255, 255, 255));
        jPanel7.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        jPanel7.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setText("Total Deductions :");
        jPanel7.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 10, -1, -1));

        jLabel25.setText("Total Earnings :");
        jPanel7.add(jLabel25, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, -1, -1));

        jLabel52.setText("0.00");
        jPanel7.add(jLabel52, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 10, 120, -1));

        jLabel58.setText("0.00");
        jPanel7.add(jLabel58, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 10, 120, -1));

        jPanel3.add(jPanel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 220, 690, 40));

        jLabel23.setText("Basic Salary");
        jPanel3.add(jLabel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 110, -1, -1));

        jLabel24.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel24.setText("Net Salary :");
        jPanel3.add(jLabel24, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 290, -1, -1));

        jLabel26.setText("TIN Contribution");
        jPanel3.add(jLabel26, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 150, -1, -1));

        jLabel27.setText("Pag-ibig Contribution");
        jPanel3.add(jLabel27, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 130, -1, -1));

        jLabel28.setText("PhilHealth Contribution");
        jPanel3.add(jLabel28, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 110, -1, -1));

        jLabel29.setText("SSS Contribution");
        jPanel3.add(jLabel29, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 90, -1, -1));

        jLabel30.setText("T I N");
        jPanel3.add(jLabel30, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 330, -1, -1));

        jLabel31.setText("Pag-ibig Number");
        jPanel3.add(jLabel31, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 310, -1, -1));

        jLabel32.setText("PhilHealth Number");
        jPanel3.add(jLabel32, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 290, -1, -1));

        jLabel33.setText("SSS Number");
        jPanel3.add(jLabel33, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 270, -1, -1));

        jLabel34.setText(":");
        jPanel3.add(jLabel34, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 330, -1, -1));

        jLabel35.setText(":");
        jPanel3.add(jLabel35, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 270, -1, -1));

        jLabel36.setText(":");
        jPanel3.add(jLabel36, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 290, -1, -1));

        jLabel37.setText(":");
        jPanel3.add(jLabel37, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 310, -1, -1));

        jLabel38.setText(":");
        jPanel3.add(jLabel38, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 110, -1, -1));

        jLabel40.setText(":");
        jPanel3.add(jLabel40, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 90, -1, -1));

        jLabel41.setText(":");
        jPanel3.add(jLabel41, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 150, -1, -1));

        jLabel42.setText(":");
        jPanel3.add(jLabel42, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 90, -1, -1));

        jLabel43.setText(":");
        jPanel3.add(jLabel43, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 110, -1, -1));

        jLabel44.setText(":");
        jPanel3.add(jLabel44, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 130, -1, -1));

        jLabel45TINN.setText("0");
        jPanel3.add(jLabel45TINN, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 330, 120, -1));

        jLabel47AL.setText("0.00");
        jPanel3.add(jLabel47AL, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 90, 120, -1));

        jLabel49.setText("0.00");
        jPanel3.add(jLabel49, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 90, 120, -1));

        jLabel50.setText("0.00");
        jPanel3.add(jLabel50, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 110, 120, -1));

        jLabel51.setText("0.00");
        jPanel3.add(jLabel51, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 130, 120, -1));

        jLabel53SSSN.setText("0");
        jPanel3.add(jLabel53SSSN, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 270, 120, -1));

        jLabel5PHN.setText("0");
        jPanel3.add(jLabel5PHN, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 290, 120, -1));

        jLabel55PN.setText("0");
        jPanel3.add(jLabel55PN, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 310, 120, -1));

        jLabel56.setText("0.00");
        jPanel3.add(jLabel56, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 110, 120, -1));

        jLabel57.setText("0.00");
        jPanel3.add(jLabel57, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 150, 120, -1));

        jLabel48.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel48.setText("0.00");
        jPanel3.add(jLabel48, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 290, 120, -1));

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 210, 690, 420));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1024, 768));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        this.hide();
        MotorPH_EmpInfoFrame employeeObj = new MotorPH_EmpInfoFrame();
        employeeObj.show();;
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
       MotorPH_EmpFrame emppageObj = new MotorPH_EmpFrame();
        emppageObj.show();
        this.hide();
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        this.hide();
        MotorPH_LoginFrame loginObj = new MotorPH_LoginFrame();
        loginObj.show();
    }//GEN-LAST:event_jButton6ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MotorPH_PayslipFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MotorPH_PayslipFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MotorPH_PayslipFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MotorPH_PayslipFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MotorPH_PayslipFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JComboBox<String> jComboBox1Term;
    private javax.swing.JComboBox<String> jComboBox2Month;
    private javax.swing.JComboBox<String> jComboBox3;
    private javax.swing.JComboBox<String> jComboBox4Year;
    private javax.swing.JComboBox<String> jComboBox5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel10BD;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel15ED;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel43;
    private javax.swing.JLabel jLabel44;
    private javax.swing.JLabel jLabel45TINN;
    private javax.swing.JLabel jLabel47AL;
    private javax.swing.JLabel jLabel48;
    private javax.swing.JLabel jLabel49;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel50;
    private javax.swing.JLabel jLabel51;
    private javax.swing.JLabel jLabel52;
    private javax.swing.JLabel jLabel53SSSN;
    private javax.swing.JLabel jLabel55PN;
    private javax.swing.JLabel jLabel56;
    private javax.swing.JLabel jLabel57;
    private javax.swing.JLabel jLabel58;
    private javax.swing.JLabel jLabel5PHN;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel jLabel9PD;
    private javax.swing.JLabel jLabelEmpName;
    private javax.swing.JLabel jLabelEmpfistName;
    private javax.swing.JLabel jLabelEmplastName;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    // End of variables declaration//GEN-END:variables
}
