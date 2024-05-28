/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.home;

/**
 *
 * @author hp
 */
public class Bean_PR {
     private int id;
    private String lastName;
    private String firstName;
    private String basicsalary;
    private String ricesubsidy;
    private String phoneallowance;
    private String clothingallowance;
    
   

    public Bean_PR(int id, String lastName, String firstName, String basicsalary, String ricesubsidy, String phoneallowance, String clothingallowance) {
        this.id = id;
        this.lastName = lastName;
        this.firstName = firstName;
        this.basicsalary = basicsalary;
        this.ricesubsidy = ricesubsidy;
        this.phoneallowance = phoneallowance;
        this.clothingallowance = clothingallowance;
   
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getBasicsalary() {
        return basicsalary;
    }

    public void setBasicsalary(String basicsalary) {
        this.basicsalary = basicsalary;
    }

    public String getRicesubsidy() {
        return ricesubsidy;
    }

    public void setRicesubsidy(String ricesubsidy) {
        this.ricesubsidy = ricesubsidy;
    }

    public String getPhoneallowance() {
        return phoneallowance;
    }

    public void setPhoneallowance(String phoneallowance) {
        this.phoneallowance = phoneallowance;
    }

    public String getClothingallowance() {
        return clothingallowance;
    }

    public void setClothingallowance(String clothingallowance) {
        this.clothingallowance = clothingallowance;
    }

    
    
    
}
