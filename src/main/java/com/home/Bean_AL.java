/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.home;

/**
 *
 * @author hp
 */
public class Bean_AL {
        private int id;
    private String lastName;
    private String firstName;
    private String riceAl;
    private String phonAl;
    private String clothAl;
    
    

    public Bean_AL(int id, String lastName, String firstName, String riceAl, String phonAl, String clothAl) {
        this.id = id;
        this.lastName = lastName;
        this.firstName = firstName;
         this.riceAl = riceAl;
        this.phonAl = phonAl;
        this.clothAl = clothAl;
       
      
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

    
     public String getRiceAl() {
        return riceAl;
    }

    public void setRiceAl(String riceAl) {
        this.riceAl = riceAl;
    }

    
    public String getPhonAl() {
        return phonAl;
    }

    public void setPhonAl(String phonAl) {
        this.phonAl = phonAl;
    }

    public String getClothAl() {
        return clothAl;
    }

    public void setClothAl(String clothAl) {
        this.clothAl = clothAl;
    }

   
    
    
    
    
}
