/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.symmetrical_umbrella.artem0179.orderAccounter.model;

import java.io.Serializable;

/**
 *
 * @author рпи
 */
public class Client implements Serializable {
    private String name;
    private String surname; 
    private String deliveryAdress;
    private int phoneNumber;
    private int discount;

    
   
    public Client (String name, String surname, String deliveryAdress, int phoneNumber){
        this.name = name;
        this.surname = surname;
        this.deliveryAdress = deliveryAdress;
        this.phoneNumber = phoneNumber;
    }
    
    public Client (String name, String surname, String deliveryAdress, int phoneNumber,
        int discount){
        this(name, surname, deliveryAdress, phoneNumber);
        this.discount = discount;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getDeliveryAdress() {
        return deliveryAdress;
    }

    public int getPhoneNumber() {
        return phoneNumber;
    }

    public int getDiscount() {
        return discount;
    }
        
    
    
    
    
    
}
