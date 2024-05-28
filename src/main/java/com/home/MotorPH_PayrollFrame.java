/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.home;

import com.databaseCon.MotorPH_DB;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author hp
 */
public class MotorPH_PayrollFrame extends javax.swing.JFrame {

    /**
     * Creates new form MotorPH_PayrollFrame
     */
    public MotorPH_PayrollFrame() {
        initComponents();
        jLabelEmpfistName.setText(String.valueOf(Bal.AdFirstName).toString());
        jLabelEmplastName.setText(String.valueOf(Bal.AdLastName ).toString());
      
         this.setResizable(false);
         
         
        jTable1.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent event) {
                if (!event.getValueIsAdjusting()) {
                    int selectedRow = jTable1.getSelectedRow();
                    if (selectedRow != -1) {
                        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
                        String id = model.getValueAt(selectedRow, 0).toString(); // Assuming the ID is in the first column
                        String basicSalaryStr = model.getValueAt(selectedRow, model.findColumn("Basic Salary")).toString().replace(",", "");
                         float basicSalary = Float.parseFloat(basicSalaryStr);
                         String basicSalaryStr1 = model.getValueAt(selectedRow, model.findColumn("Basic Salary")).toString().replace(",", "");
                        float basicSalary1 = Float.parseFloat(basicSalaryStr1);
                        String basicSalaryStr2 = model.getValueAt(selectedRow, model.findColumn("Basic Salary")).toString().replace(",", "");

                        float basicSalary2 = Float.parseFloat(basicSalaryStr2);
                       String salaryText = jLabel3Salary.getText();
                       
                        float salary = Float.parseFloat(salaryText.replace(",", ""));
                                              
                         
                     String totalAllowancesStr = getTotalAllowancesFromDatabase(id);
                        float totalAllowances = Float.parseFloat(totalAllowancesStr);
                        DecimalFormat decimalFormat5 = new DecimalFormat("#,###.00");
                        String formattedNumberTA = decimalFormat5.format(totalAllowances);
                        jLabel9TA.setText(formattedNumberTA);

                        
                        String sssContributionStr = calculateSSSContribution(basicSalary);
                        float sssContribution = Float.parseFloat(sssContributionStr);
                        DecimalFormat decimalFormat6 = new DecimalFormat("#,###.00");
                        String formattedNumberSSS = decimalFormat6.format(sssContribution);
                        jLabel9SSS.setText(formattedNumberSSS);

                        
                       String philHealthContributionStr = calculatePhilHealthContribution(basicSalary1);
                        float philHealthContribution = Float.parseFloat(philHealthContributionStr);
                        DecimalFormat decimalFormat7 = new DecimalFormat("#,###.00");
                        String formattedNumberPH = decimalFormat7.format(philHealthContribution);
                        jLabel9PH.setText(formattedNumberPH);

                         
                         
                         
                        String pagIBIGContribution = calculatePagIBIGContribution(basicSalary2);
                        
                        jLabel9PBG.setText(pagIBIGContribution);
                        
                         String totalAllowancesText = jLabel9TA.getText();
                         
                    }   
                }
            }
        });
         
    }

    
    
    
    
    
    
    
    private String calculatePagIBIGContribution(float basicSalary) {
    String pagIBIGContribution = "";
    
    float employeeContributionRate;
    float employerContributionRate;
    
    if (basicSalary >= 1000 && basicSalary <= 1500) {
        employeeContributionRate = 0.01f; // 1%
        employerContributionRate = 0.02f; // 2%
    } else {
        employeeContributionRate = 0.02f; // 2%
        employerContributionRate = 0.02f; // 2%
    }
    
    float totalContribution = basicSalary * (employeeContributionRate + employerContributionRate);
    
    if (totalContribution > 100) {
        totalContribution = 100; // Maximum contribution amount is 100
    }
    
    pagIBIGContribution = String.valueOf(totalContribution);

    return pagIBIGContribution;
}
    
    
    
    
    
    private String calculatePhilHealthContribution(float basicSalary) {
    String philHealthContribution = "";
    
    float premiumRate = 0.03f; // Premium rate is 3%
    float monthlyPremium = 0;

    if (basicSalary <= 10000) {
        monthlyPremium = 300;
    } else if (basicSalary > 10000 && basicSalary <= 59999.99) {
        monthlyPremium = basicSalary * premiumRate;
        if (monthlyPremium < 300) {
            monthlyPremium = 300;
        } else if (monthlyPremium > 1800) {
            monthlyPremium = 1800;
        }
    } else if (basicSalary >= 60000) {
        monthlyPremium = 1800;
    }
    
    float employeeShare = monthlyPremium * 0.5f; // Employee's share is 50%

    philHealthContribution = String.valueOf(employeeShare);

    return philHealthContribution;
}
    
    
    

// Method to retrieve the total sum of allowances from the database
private String getTotalAllowancesFromDatabase(String id) {
    String totalAllowances = "";
    try {
        String query = "SELECT `Rice Subsidy`, `Phone Allowance`, `Clothing Allowance` FROM motorphdb WHERE ID = ?";
        PreparedStatement ps = MotorPH_DB.con.prepareStatement(query);
        ps.setString(1, id);
        ResultSet rs = ps.executeQuery();
        
        if (rs.next()) {
            // Retrieve individual allowances from the ResultSet
            float riceSubsidy = Float.parseFloat(rs.getString("Rice Subsidy").replace(",", ""));
            float phoneAllowance = Float.parseFloat(rs.getString("Phone Allowance").replace(",", ""));
            float clothingAllowance = Float.parseFloat(rs.getString("Clothing Allowance").replace(",", ""));
            
            // Calculate the total sum of allowances
            float totalSum = riceSubsidy + phoneAllowance + clothingAllowance;
            totalAllowances = String.format("%.2f", totalSum);
        }
    } catch (SQLException e) {
        e.printStackTrace(); // Handle or log the exception as needed
    }
    return totalAllowances;
}

    
private String calculateSSSContribution(float basicSalary) {
    String sssContribution = "";

    if (basicSalary < 3250) {
        sssContribution = "135.00";
    } else if (basicSalary >= 3250 && basicSalary <= 24750) {
        float[] salaryRanges = {3250, 3750, 4250, 4750, 5250, 5750, 6250, 6750, 7250, 7750, 8250, 8750, 9250,
                9750, 10250, 10750, 11250, 11750, 12250, 12750, 13250, 13750, 14250, 14750, 15250, 15750, 16250,
                16750, 17250, 17750, 18250, 18750, 19250, 19750, 20250, 20750, 21250, 21750, 22250, 22750, 23250,
                23750, 24250, 24750};

        float[] contributions = {135.00f, 157.50f, 180.00f, 202.50f, 225.00f, 247.50f, 270.00f, 292.50f, 315.00f,
                337.50f, 360.00f, 382.50f, 405.00f, 427.50f, 450.00f, 472.50f, 495.00f, 517.50f, 540.00f, 562.50f,
                585.00f, 607.50f, 630.00f, 652.50f, 675.00f, 697.50f, 720.00f, 742.50f, 765.00f, 787.50f, 810.00f,
                832.50f, 855.00f, 877.50f, 900.00f, 922.50f, 945.00f, 967.50f, 990.00f, 1012.50f, 1035.00f, 1057.50f,
                1080.00f, 1102.50f, 1125.00f};

        for (int i = 0; i < salaryRanges.length; i++) {
            if (basicSalary >= salaryRanges[i] && basicSalary < salaryRanges[i + 1]) {
                sssContribution = String.valueOf(contributions[i]);
                break;
            }
        }
    } else {
        sssContribution = "1125.00";
    }

    return sssContribution;
}    




    
     private void loadDataToTable(List<Bean_PR> list) {
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        model.setRowCount(0);
        Object[] row = new Object[7];
        for (Bean_PR bean : list) {
            row[0] = bean.getId();
            row[1] = bean.getLastName();
            row[2] = bean.getFirstName();
            row[3] = bean.getBasicsalary();
            row[4] = bean.getRicesubsidy();
            row[5] = bean.getPhoneallowance();
            row[6] = bean.getClothingallowance();
            model.addRow(row);
        }
    }
    
    
     
    

   
    
    
    public void loadTable (){
        Bal_PR bal = new Bal_PR();
        List list =  bal.loadDataPR();
        loadDataToTable(list);
        
    }
        
    public void search(String str) {
        Bal_PR bal = new Bal_PR();
        List<Bean_PR> list = bal.searchEmployee(str);
        
        DefaultTableModel dtm = (DefaultTableModel) jTable1.getModel();
        dtm.setRowCount(0);

        for (Bean_PR bean : list) {
            Object[] rowData = {
                bean.getId(),
                bean.getLastName(),
                bean.getFirstName(),
                bean.getBasicsalary(),
                   bean.getRicesubsidy(),
                    bean.getPhoneallowance(),
                    bean.getClothingallowance()
               
            };
            dtm.addRow(rowData);
             
        }
    } 
    
   private void updateBasicSalary(int id, String newBasicSalary) {
    try {
        String query = "UPDATE motorphdb SET `Basic Salary` = ? WHERE ID = ?";
        PreparedStatement ps = MotorPH_DB.con.prepareStatement(query);
        ps.setString(1, newBasicSalary);
        ps.setInt(2, id);
        
        // Execute the update query
        ps.executeUpdate();
    } catch (Exception ex) {
        JOptionPane.showMessageDialog(this, "Error updating Basic Salary: " + ex.getMessage());
    }
}
    
    public void clearTextFieldsData(){
        jTextField2.setText("");
        jTextField3THW.setText("");
        
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
        jPanel6 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        jButton4 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        jLabel19 = new javax.swing.JLabel();
        jLabelEmpfistName = new javax.swing.JLabel();
        jLabelEmpName = new javax.swing.JLabel();
        jLabelEmplastName = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel4 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jButton2BSU = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9PBG = new javax.swing.JLabel();
        jLabel10NS = new javax.swing.JLabel();
        jButton7GPS = new javax.swing.JButton();
        jLabel15 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel16 = new javax.swing.JLabel();
        jTextField3THW = new javax.swing.JTextField();
        jButton8TMW = new javax.swing.JButton();
        jLabel18 = new javax.swing.JLabel();
        jLabel20TD = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jLabel9GS1 = new javax.swing.JLabel();
        jLabel9SSS = new javax.swing.JLabel();
        jLabel9TIN = new javax.swing.JLabel();
        jLabel9PH = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jLabel9TA = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jLabel26 = new javax.swing.JLabel();
        jLabel3Salary = new javax.swing.JLabel();
        jComboBox1Term = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(0, 0, 0));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 250, 80));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1024, 100));

        jPanel6.setBackground(new java.awt.Color(0, 0, 0));
        jPanel6.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel11.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("Office Hours: 8:00AM - 5:00PM");
        jPanel6.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, -1, 20));

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

        jLabel27.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel27.setForeground(new java.awt.Color(255, 255, 255));
        jLabel27.setText("MO-IT103 - Computer Programming 2");
        jPanel6.add(jLabel27, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 70, -1, 20));

        jLabel28.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel28.setForeground(new java.awt.Color(255, 255, 255));
        jLabel28.setText("Section : A1101");
        jPanel6.add(jLabel28, new org.netbeans.lib.awtextra.AbsoluteConstraints(930, 50, -1, 20));

        jLabel17.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(255, 255, 255));
        jLabel17.setText("Group 1");
        jPanel6.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(970, 30, -1, 20));

        jLabel29.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel29.setForeground(new java.awt.Color(255, 255, 255));
        jPanel6.add(jLabel29, new org.netbeans.lib.awtextra.AbsoluteConstraints(870, 10, -1, 20));

        jPanel1.add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 670, 1024, 100));

        jButton4.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButton4.setForeground(new java.awt.Color(51, 51, 51));
        jButton4.setText("Home");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 100, 208, 40));

        jButton1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButton1.setText("Reports");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 100, 208, 40));

        jButton3.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButton3.setText("Employee Information");
        jButton3.setPreferredSize(new java.awt.Dimension(72, 23));
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 100, 208, 40));

        jButton5.setBackground(new java.awt.Color(153, 153, 153));
        jButton5.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButton5.setForeground(new java.awt.Color(255, 255, 255));
        jButton5.setText("Payroll");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton5, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 100, 210, 40));

        jButton6.setBackground(new java.awt.Color(204, 0, 0));
        jButton6.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButton6.setForeground(new java.awt.Color(255, 255, 255));
        jButton6.setText("Logout");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton6, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 100, 205, 40));

        jPanel5.setBackground(new java.awt.Color(204, 204, 204));
        jPanel5.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(153, 153, 153), 2, true));
        jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel5.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 10, 150, 150));

        jLabelEmpfistName.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabelEmpfistName.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelEmpfistName.setText("jLabel18");
        jLabelEmpfistName.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jPanel5.add(jLabelEmpfistName, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 200, 260, 60));

        jLabelEmpName.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        jLabelEmpName.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelEmpName.setText("Welcome!");
        jPanel5.add(jLabelEmpName, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 150, 260, 60));

        jLabelEmplastName.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabelEmplastName.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelEmplastName.setText("jLabel18");
        jLabelEmplastName.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jPanel5.add(jLabelEmplastName, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 220, 260, 60));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Admin");
        jPanel5.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 190, 260, -1));

        jPanel1.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 140, 260, 530));

        jTextField1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextField1KeyReleased(evt);
            }
        });
        jPanel1.add(jTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 150, 270, -1));

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Last Name", "First Name", "Basic Salary", "Rice Subsidy", "Phone Allowance", "Clothing Allowance"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, true, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTable1);
        if (jTable1.getColumnModel().getColumnCount() > 0) {
            jTable1.getColumnModel().getColumn(0).setPreferredWidth(4);
            jTable1.getColumnModel().getColumn(1).setPreferredWidth(50);
            jTable1.getColumnModel().getColumn(2).setPreferredWidth(50);
            jTable1.getColumnModel().getColumn(3).setPreferredWidth(60);
        }

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 180, 690, 70));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel4.setText("Total Minutes Work :");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 320, 150, 20));

        jTextField2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextField2KeyReleased(evt);
            }
        });
        jPanel1.add(jTextField2, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 280, 150, -1));

        jButton2BSU.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButton2BSU.setText("Update");
        jButton2BSU.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2BSUActionPerformed(evt);
            }
        });
        jPanel1.add(jButton2BSU, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 280, -1, -1));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel5.setText("Term :");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 150, -1, -1));

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel7.setText("Amount :");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 280, -1, -1));

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Net Salary :");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 560, -1, -1));

        jLabel9PBG.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel9PBG.setText("0");
        jPanel1.add(jLabel9PBG, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 500, 170, 20));

        jLabel10NS.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel10NS.setText("0");
        jPanel1.add(jLabel10NS, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 560, 240, -1));

        jButton7GPS.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButton7GPS.setText("Generate Payslip");
        jButton7GPS.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7GPSActionPerformed(evt);
            }
        });
        jPanel1.add(jButton7GPS, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 610, -1, -1));

        jLabel15.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel15.setText("Gross Salary :");
        jPanel1.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 440, -1, -1));

        jPanel3.setBackground(new java.awt.Color(0, 0, 0));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 560, 150, 40));

        jLabel16.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel16.setText("Pag-ibig :");
        jPanel1.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 500, -1, -1));

        jTextField3THW.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextField3THWKeyReleased(evt);
            }
        });
        jPanel1.add(jTextField3THW, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 320, 150, -1));

        jButton8TMW.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButton8TMW.setText("Submit");
        jButton8TMW.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8TMWActionPerformed(evt);
            }
        });
        jPanel1.add(jButton8TMW, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 320, -1, -1));

        jLabel18.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel18.setText("Total Deductions :");
        jPanel1.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 530, -1, -1));

        jLabel20TD.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel20TD.setText("0");
        jPanel1.add(jLabel20TD, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 530, 180, -1));

        jLabel21.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel21.setText("Update Basic Salary :");
        jPanel1.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 250, -1, -1));

        jLabel20.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel20.setText("Deductions :");
        jPanel1.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 470, -1, -1));

        jLabel22.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel22.setText("SSS :");
        jPanel1.add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 470, -1, -1));

        jLabel23.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel23.setText("PhilHealth :");
        jPanel1.add(jLabel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 470, -1, -1));

        jLabel24.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel24.setText("TIN :");
        jPanel1.add(jLabel24, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 500, -1, -1));

        jLabel9GS1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel9GS1.setText("0");
        jPanel1.add(jLabel9GS1, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 440, 180, -1));

        jLabel9SSS.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel9SSS.setText("0");
        jPanel1.add(jLabel9SSS, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 470, 170, -1));

        jLabel9TIN.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel9TIN.setText("0");
        jPanel1.add(jLabel9TIN, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 500, 170, -1));

        jLabel9PH.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel9PH.setText("0");
        jPanel1.add(jLabel9PH, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 470, 170, -1));

        jLabel25.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel25.setText("Salary :");
        jPanel1.add(jLabel25, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 400, -1, -1));

        jLabel9TA.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel9TA.setText("0");
        jPanel1.add(jLabel9TA, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 420, 180, -1));

        jButton2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButton2.setText("Clear");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 360, -1, -1));

        jLabel26.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel26.setText("Total Allowances :");
        jPanel1.add(jLabel26, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 420, -1, -1));

        jLabel3Salary.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel3Salary.setText("0");
        jPanel1.add(jLabel3Salary, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 400, 150, -1));

        jComboBox1Term.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Term 1 (Month Day: 1st day until 15th)", "Term 2 (Month Day:16th day until last day)" }));
        jPanel1.add(jComboBox1Term, new org.netbeans.lib.awtextra.AbsoluteConstraints(752, 150, 240, -1));

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel6.setText("Search :");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 150, -1, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1024, 768));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        this.hide();
        MotorPH_HomeJFrame loginObj = new MotorPH_HomeJFrame();
        loginObj.show();
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        this.hide();
        MotorPH_AttFrame loginObj = new MotorPH_AttFrame();
        loginObj.show();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        this.hide();
        MotorPH_AddEmpFrame empObj = new MotorPH_AddEmpFrame();
        empObj.show();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        this.hide();
        MotorPH_PayrollFrame payrollObj = new MotorPH_PayrollFrame();
        payrollObj.show();
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        this.hide();
        MotorPH_LoginFrame loginObj = new MotorPH_LoginFrame();
        loginObj.show();
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton7GPSActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7GPSActionPerformed
          try {
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/emp_msdb", "root", "Password@123");
        Statement stmt = conn.createStatement();

        // Get current date and time as a string
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String currentDate = dateFormat.format(new Date());

        // Get values from jTable1
        int selectedRow = jTable1.getSelectedRow();
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        int id = Integer.parseInt(model.getValueAt(selectedRow, model.findColumn("ID")).toString());
        String riceSubsidy = model.getValueAt(selectedRow, model.findColumn("Rice Subsidy")).toString();
        String phoneAllowance = model.getValueAt(selectedRow, model.findColumn("Phone Allowance")).toString();
        String clothingAllowance = model.getValueAt(selectedRow, model.findColumn("Clothing Allowance")).toString();

        // Get values from jLabels
        String totalAllowance = jLabel9TA.getText();
        String sss = jLabel9SSS.getText();
        String philhealth = jLabel9PH.getText();
        String pagibig = jLabel9PBG.getText();
        String tin = jLabel9TIN.getText();
        String totalDeductions = jLabel20TD.getText();
        String totalNetSalary = jLabel10NS.getText();

        // Get term from jComboBox1Term
        String term = jComboBox1Term.getSelectedItem().toString();

        // Construct the SQL query
        String sql = "INSERT INTO payroll (ID, Date, `Rice Subsidy`, `Phone Allowance`, `Clothing Allowance`, `Total Allowances`, SSS, Philhealth, `Pag-ibig`, TIN, `Total Deductions`, `Total Net Salary`, Term) " +
                     "VALUES (" + id + ", '" + currentDate + "', '" + riceSubsidy + "', '" + phoneAllowance + "', '" + clothingAllowance + "', '" + totalAllowance + "', '" + sss + "', '" + philhealth + "', '" + pagibig + "', '" + tin + "', '" + totalDeductions + "', '" + totalNetSalary + "', '" + term + "')";

        // Execute the query
        stmt.executeUpdate(sql);

        JOptionPane.showMessageDialog(null, "Payslip generated successfully!");

        conn.close();
    } catch (SQLException ex) {
        JOptionPane.showMessageDialog(null, "Error inserting data into the database: " + ex.getMessage(), "Database Error", JOptionPane.ERROR_MESSAGE);
    }
        
        
        
    }//GEN-LAST:event_jButton7GPSActionPerformed

    private void jTextField1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField1KeyReleased
                String searchString = jTextField1.getText();
                if (!searchString.matches("\\d*")) {
        JOptionPane.showMessageDialog(null, "Please enter numeric characters only.", "Invalid Input", JOptionPane.WARNING_MESSAGE);
        jTextField1.setText(""); // Clear the text field
        return;
    }
                search(searchString);
    }//GEN-LAST:event_jTextField1KeyReleased

   private String formatNumber(String number) {
    try {
        // Remove commas from the input number
        number = number.replaceAll(",", "");

        // Parse the input number
        long value = Long.parseLong(number);

        // Format the number with commas
        return String.format("%,d", value);
    } catch (NumberFormatException e) {
        // Handle invalid input gracefully (e.g., log error, show error message)
        return null; // or throw an exception if needed
    }
 } 
    
    
    private void jButton2BSUActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2BSUActionPerformed
if (jTable1.getRowCount() != 1 || jTable1.getSelectedRowCount() != 1) {
        JOptionPane.showMessageDialog(this, "Please select one employee from the table.");
        return;
    }
    
    // Get the selected row index from jTable1
    int selectedRowIndex = jTable1.getSelectedRow();
    
    // Check if a row is selected
    if (selectedRowIndex != -1) {
        try {
            // Get the ID from the selected row in jTable1
            int id = (int) jTable1.getValueAt(selectedRowIndex, 0);
            
            // Get the new Basic Salary from jTextField2
            String newBasicSalary = jTextField2.getText();
            
            // Update the Basic Salary in the database
            newBasicSalary = formatNumber(newBasicSalary);
            updateBasicSalary(id, newBasicSalary);
            
            // Reload the table to reflect the changes
            loadTable();
            
            // Show success message
            JOptionPane.showMessageDialog(this, "Basic Salary updated successfully!");
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Error updating Basic Salary: " + ex.getMessage());
        }
    } else {
        JOptionPane.showMessageDialog(this, "Please select one employee from the table.");
    }
    }//GEN-LAST:event_jButton2BSUActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        clearTextFieldsData();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton8TMWActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8TMWActionPerformed
     
          String totalHoursWorkedStr = jTextField3THW.getText().trim();

    // Check if the input is numeric
    if (!totalHoursWorkedStr.matches("\\d+")) {
        JOptionPane.showMessageDialog(null, "Total hours worked must be a number without decimal points.", "Invalid Input", JOptionPane.ERROR_MESSAGE);
        return;
    }

    // Parse total hours worked to integer
    int totalHoursWorked = Integer.parseInt(totalHoursWorkedStr);

    // Get the selected row from jTable1
    int selectedRow = jTable1.getSelectedRow();

    // Check if a row is selected
    if (selectedRow == -1) {
        JOptionPane.showMessageDialog(null, "Please select a row from the table.", "No Row Selected", JOptionPane.ERROR_MESSAGE);
        return;
    }

    // Assuming basicSalary is obtained from the jTable using DefaultTableModel named model
    DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
    float basicSalary = Float.parseFloat(model.getValueAt(selectedRow, model.findColumn("Basic Salary")).toString().replace(",", ""));

    // Assuming total weekdays in a month, office hours per day, and minutes per hour are provided
    int totalWeekdaysInMonth = 20; // Assuming 20 weekdays in a month
    int officeHoursPerDay = 8; // Assuming 8 hours per day
    int minutesPerHour = 60;

    // Calculate per minute salary
    float perMinuteSalary = basicSalary / (totalWeekdaysInMonth * officeHoursPerDay * minutesPerHour);

    // Calculate salary
   float salary = totalHoursWorked * perMinuteSalary;
    DecimalFormat decimalFormat4 = new DecimalFormat("#,###.00");
    String formattedNumberSal = decimalFormat4.format(salary);
    jLabel3Salary.setText(formattedNumberSal);


    // Assuming jLabel9TA contains the total allowances
    float totalAllowances = Float.parseFloat(jLabel9TA.getText().replace(",", ""));

    // Calculate Gross Salary
    float grossSalary = salary + totalAllowances;
    DecimalFormat decimalFormat3 = new DecimalFormat("#,###.00");
    String formattedNumberGS = decimalFormat3.format(grossSalary);
    jLabel9GS1.setText(formattedNumberGS);
    

    // Assuming jLabel9SSS, jLabel9PH, and jLabel9PBG contain SSS, Philhealth, and PagIBIG contributions respectively
    float sssContribution = Float.parseFloat(jLabel9SSS.getText().replace(",", ""));
    float philHealthContribution = Float.parseFloat(jLabel9PH.getText().replace(",", ""));
    float pagIBIGContribution = Float.parseFloat(jLabel9PBG.getText().replace(",", ""));

    // Calculate Total Deductions
    float totalDeductions = sssContribution + philHealthContribution + pagIBIGContribution;

    // Calculate Taxable Income
    float taxableIncome = grossSalary - totalDeductions;

    // Calculate Withholding Tax based on Taxable Income
    float withholdingTax = calculateWithholdingTax(taxableIncome);

    DecimalFormat decimalFormat2 = new DecimalFormat("#,###.00");
    String formattedNumberTIN = decimalFormat2.format(withholdingTax);

    // Check if withholdingTax is zero and adjust the format accordingly
    if (withholdingTax == 0) {
        formattedNumberTIN = "0.00";
    }

    jLabel9TIN.setText(formattedNumberTIN);

    
      float totalDeductions1 = salary - sssContribution - philHealthContribution - pagIBIGContribution - withholdingTax;
      float totalDeductions2 = salary - totalDeductions1;
        DecimalFormat decimalFormat1 = new DecimalFormat("#,###.00");
        String formattedNumberTD = decimalFormat1.format(totalDeductions2);
        jLabel20TD.setText(formattedNumberTD);

      
      float totalNetSal = (salary + totalAllowances) - totalDeductions2;
    DecimalFormat decimalFormat = new DecimalFormat("#,###.00");
    String formattedNumber = decimalFormat.format(totalNetSal);
    jLabel10NS.setText(formattedNumber);
    
   
    
    }//GEN-LAST:event_jButton8TMWActionPerformed

    private void jTextField2KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField2KeyReleased
        String searchString = jTextField2.getText();
         if (!searchString.matches("\\d*")) {
        JOptionPane.showMessageDialog(null, "Please enter numeric characters only.", "Invalid Input", JOptionPane.WARNING_MESSAGE);
        jTextField2.setText(""); // Clear the text field
        return;
    }
    }//GEN-LAST:event_jTextField2KeyReleased

    private void jTextField3THWKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField3THWKeyReleased
       String searchString = jTextField3THW.getText();
         if (!searchString.matches("\\d*")) {
        JOptionPane.showMessageDialog(null, "Please enter numeric characters only.", "Invalid Input", JOptionPane.WARNING_MESSAGE);
        jTextField3THW.setText(""); // Clear the text field
        return;
    }
    }//GEN-LAST:event_jTextField3THWKeyReleased

 private float calculateWithholdingTax(float taxableIncome) {
    float withholdingTax = 0;

    if (taxableIncome <= 20832) {
        withholdingTax = 0; // No withholding tax
    } else if (taxableIncome <= 33333) {
        withholdingTax = (taxableIncome - 20833) * 0.20f;
    } else if (taxableIncome <= 66667) {
        withholdingTax = 2500 + (taxableIncome - 33333) * 0.25f;
    } else if (taxableIncome <= 166667) {
        withholdingTax = 10833 + (taxableIncome - 66667) * 0.30f;
    } else if (taxableIncome <= 666667) {
        withholdingTax = 40833.33f + (taxableIncome - 166667) * 0.32f;
    } else {
        withholdingTax = 200833.33f + (taxableIncome - 666667) * 0.35f;
    }

    return withholdingTax;
} 

    
    
    
    
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
            java.util.logging.Logger.getLogger(MotorPH_PayrollFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MotorPH_PayrollFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MotorPH_PayrollFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MotorPH_PayrollFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MotorPH_PayrollFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton2BSU;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7GPS;
    private javax.swing.JButton jButton8TMW;
    private javax.swing.JComboBox<String> jComboBox1Term;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10NS;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel20TD;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3Salary;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9GS1;
    private javax.swing.JLabel jLabel9PBG;
    private javax.swing.JLabel jLabel9PH;
    private javax.swing.JLabel jLabel9SSS;
    private javax.swing.JLabel jLabel9TA;
    private javax.swing.JLabel jLabel9TIN;
    private javax.swing.JLabel jLabelEmpName;
    private javax.swing.JLabel jLabelEmpfistName;
    private javax.swing.JLabel jLabelEmplastName;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3THW;
    // End of variables declaration//GEN-END:variables
}
