/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.home;
import com.databaseCon.MotorPH_DBAtt;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Time;
import java.text.DateFormat;
import java.text.ParseException;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;

import javax.swing.Timer;
/**
 *
 * @author hp
 */
public class MotorPH_HomeJFrame extends javax.swing.JFrame {

    private String time;

    /**
     * Creates new form MotorPH_HomeJFrame
     */
    public MotorPH_HomeJFrame() {
        initComponents();
        currentDate();
        time();
         jLabelEmpfistName.setText(String.valueOf(Bal.AdFirstName).toString());
        jLabelEmplastName.setText(String.valueOf(Bal.AdLastName ).toString());
         this.setResizable(false);
    }
public void currentDate(){
        
        Calendar cal = new GregorianCalendar();
        SimpleDateFormat monthFormat = new SimpleDateFormat("MMMM");
        String month = monthFormat.format(cal.getTime());
        int year = cal.get(Calendar.YEAR);
        int day = cal.get(Calendar.DAY_OF_MONTH);
        
        jLabel6Date.setText(month+ "  "+day+" , "+year);
        int second = cal.get(Calendar.SECOND);
        int minute = cal.get(Calendar.MINUTE);
        int hour = cal.get(Calendar.HOUR_OF_DAY);
        
                       
    }
    Timer t;
    SimpleDateFormat st;
    
    public void time() {
        t = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Date dt = new Date();
                st = new SimpleDateFormat("hh:mm:ss a");
                String tt = st.format(dt);
                jLabel6Time.setText(tt);
            }
        });
        t.start();
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
        jLabel7 = new javax.swing.JLabel();
        jLabel17CheckIN1 = new javax.swing.JLabel();
        jLabel8CheckOUT = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jLabel19 = new javax.swing.JLabel();
        jLabelEmpfistName = new javax.swing.JLabel();
        jLabelEmpName = new javax.swing.JLabel();
        jLabelEmplastName = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jPanel8 = new javax.swing.JPanel();
        jLabel6Time = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jPanel9 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jPanel10 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        jButton2CheckIN = new javax.swing.JButton();
        jButton1CheckOUT = new javax.swing.JButton();
        jPanel11 = new javax.swing.JPanel();
        jPanel12 = new javax.swing.JPanel();
        jLabel6Date = new javax.swing.JLabel();
        jButton4 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("CHECK - OUT TIME :");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 560, 120, 20));

        jLabel17CheckIN1.setBackground(new java.awt.Color(153, 153, 153));
        jLabel17CheckIN1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel17CheckIN1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel17CheckIN1.setText("You have not check-in yet.");
        jLabel17CheckIN1.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jLabel17CheckIN1.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        jPanel1.add(jLabel17CheckIN1, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 520, 150, 20));

        jLabel8CheckOUT.setBackground(new java.awt.Color(153, 153, 153));
        jLabel8CheckOUT.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel8CheckOUT.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8CheckOUT.setText("You have not check-out yet.");
        jLabel8CheckOUT.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jLabel8CheckOUT.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jPanel1.add(jLabel8CheckOUT, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 560, -1, 20));

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("CHECK - IN TIME :");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 520, 110, 20));

        jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("CHECK - IN TIME :");
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 520, 110, 20));

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

        jLabel18.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(255, 255, 255));
        jLabel18.setText("MO-IT103 - Computer Programming 2");
        jPanel6.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 70, -1, 20));

        jLabel21.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(255, 255, 255));
        jLabel21.setText("Section : A1101");
        jPanel6.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(930, 50, -1, 20));

        jLabel15.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setText("Group 1");
        jPanel6.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(970, 30, -1, 20));

        jLabel20.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(255, 255, 255));
        jPanel6.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(870, 10, -1, 20));

        jPanel1.add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 670, 1024, 100));

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

        jPanel3.setBackground(new java.awt.Color(0, 0, 0));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("CURRENT TIME");
        jPanel3.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 20, -1, -1));

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 190, 190, 60));

        jPanel8.setBackground(new java.awt.Color(255, 255, 255));
        jPanel8.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));

        jLabel6Time.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel6Time.setText("jLabel6");
        jPanel8.add(jLabel6Time);

        jPanel1.add(jPanel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 200, 240, 40));

        jPanel4.setBackground(new java.awt.Color(0, 0, 0));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("TIMEZONE");
        jPanel4.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 20, -1, -1));

        jPanel1.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 270, 190, 60));

        jPanel9.setBackground(new java.awt.Color(255, 255, 255));
        jPanel9.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel5.setText("(GMT+8) Manila, Philippines");
        jPanel9.add(jLabel5);

        jPanel1.add(jPanel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 280, 240, 40));

        jPanel10.setBackground(new java.awt.Color(0, 0, 0));
        jPanel10.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        jPanel10.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("EMPLOYEE TIME CARD");
        jPanel10.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 30, -1, -1));

        jPanel1.add(jPanel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 360, 630, 80));

        jPanel7.setBackground(new java.awt.Color(0, 0, 0));
        jPanel7.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel1.add(jPanel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 520, 130, 20));

        jButton2CheckIN.setBackground(new java.awt.Color(51, 204, 0));
        jButton2CheckIN.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButton2CheckIN.setForeground(new java.awt.Color(255, 255, 255));
        jButton2CheckIN.setText("CHECK - IN");
        jButton2CheckIN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2CheckINActionPerformed(evt);
            }
        });
        jPanel1.add(jButton2CheckIN, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 520, 120, -1));

        jButton1CheckOUT.setBackground(new java.awt.Color(153, 0, 0));
        jButton1CheckOUT.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButton1CheckOUT.setForeground(new java.awt.Color(255, 255, 255));
        jButton1CheckOUT.setText("CHECK - OUT");
        jButton1CheckOUT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1CheckOUTActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1CheckOUT, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 560, 120, -1));

        jPanel11.setBackground(new java.awt.Color(0, 0, 0));
        jPanel11.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel1.add(jPanel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 560, 130, 20));

        jPanel12.setBackground(new java.awt.Color(255, 255, 255));
        jPanel12.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true));
        jPanel12.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel6Date.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel6Date.setText("jLabel6");
        jPanel12.add(jLabel6Date, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 10, -1, 20));

        jPanel1.add(jPanel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 460, 250, 40));

        jButton4.setBackground(new java.awt.Color(153, 153, 153));
        jButton4.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButton4.setForeground(new java.awt.Color(255, 255, 255));
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

        jButton5.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButton5.setText("Payroll");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton5, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 100, 208, 40));

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

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1024, 768));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents
private boolean isCheckedIn = false;
    private void jButton2CheckINActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2CheckINActionPerformed
    if (isCheckedIn) {
        JOptionPane.showMessageDialog(null, "You are already logged in for today.");
        return;
    }

    Date currentDate = GregorianCalendar.getInstance().getTime();
    DateFormat df = DateFormat.getDateInstance();
    
    String dateString = df.format(currentDate);
    Date parsedDate;
    try {
        parsedDate = df.parse(dateString);
    } catch (ParseException e) {
        e.printStackTrace(); // Handle the exception appropriately
        return; // or do something else to handle the error
    }

    int value = Bal.AdID;
    Date d = new Date();
    SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
    String timeString = sdf.format(d);

    // Check if the user has already checked in for the current date
    boolean alreadyCheckedIn = MotorPH_DBAtt.hasCheckedIn(value, parsedDate, Time.valueOf(timeString));
    if (alreadyCheckedIn) {
        JOptionPane.showMessageDialog(null, "You are already logged in for today.");
        isCheckedIn = true; // Update check-in status
    } else {
        // Proceed to insert log entry
        Date reg = parsedDate;
        Time reg1 = Time.valueOf(timeString);
        jLabel17CheckIN1.setText(timeString);
        MotorPH_DBAtt.saveTimeInToDatabase(reg, reg1);
        isCheckedIn = true; // Update check-in status
    }
    
    }//GEN-LAST:event_jButton2CheckINActionPerformed
private boolean isCheckedOut = false;
    private void jButton1CheckOUTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1CheckOUTActionPerformed
           
    if (isCheckedOut) {
        JOptionPane.showMessageDialog(null, "You are already logged out for today.");
        return;
    }

    Date currentDate = GregorianCalendar.getInstance().getTime();
    DateFormat df = DateFormat.getDateInstance();
    
    String dateString = df.format(currentDate);
    Date parsedDate;
    try {
        parsedDate = df.parse(dateString);
    } catch (ParseException e) {
        e.printStackTrace(); // Handle the exception appropriately
        return; // or do something else to handle the error
    }

    int value = Bal.AdID;
    Date d = new Date();
    SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
    String timeString = sdf.format(d);

    // Check if the user has already checked out for the current date
    boolean alreadyCheckedOut = MotorPH_DBAtt.hasCheckedOut(value, parsedDate, Time.valueOf(timeString));
    if (alreadyCheckedOut) {
        JOptionPane.showMessageDialog(null, "You are already logged out for today.");
        isCheckedOut = true; // Update check-out status
    } else {
        // Proceed to insert log entry
        Date reg = parsedDate;
        Time reg1 = Time.valueOf(timeString);
        jLabel8CheckOUT.setText(timeString);
        MotorPH_DBAtt.saveTimeOutToDatabase(reg, reg1);
        isCheckedOut = true; // Update check-out status
    
    }//GEN-LAST:event_jButton1CheckOUTActionPerformed
    }
    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        this.hide();
        MotorPH_HomeJFrame loginObj = new MotorPH_HomeJFrame();
        loginObj.show();
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        this.hide();
        MotorPH_AttFrame loginObj = new MotorPH_AttFrame();
        loginObj.show();
        isCheckedIn = false;
    isCheckedOut = false;
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        this.hide();
        MotorPH_AddEmpFrame empObj = new MotorPH_AddEmpFrame();
        empObj.show();
        isCheckedIn = false;
    isCheckedOut = false;
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        this.hide();
        MotorPH_PayrollFrame payrollObj = new MotorPH_PayrollFrame();
        payrollObj.show();
        isCheckedIn = false;
    isCheckedOut = false;
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        this.hide();
        MotorPH_LoginFrame loginObj = new MotorPH_LoginFrame();
        loginObj.show();
        isCheckedIn = false;
    isCheckedOut = false;
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
            java.util.logging.Logger.getLogger(MotorPH_HomeJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MotorPH_HomeJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MotorPH_HomeJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MotorPH_HomeJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MotorPH_HomeJFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton1CheckOUT;
    private javax.swing.JButton jButton2CheckIN;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel17CheckIN1;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel6Date;
    private javax.swing.JLabel jLabel6Time;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8CheckOUT;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel jLabelEmpName;
    private javax.swing.JLabel jLabelEmpfistName;
    private javax.swing.JLabel jLabelEmplastName;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    // End of variables declaration//GEN-END:variables
}