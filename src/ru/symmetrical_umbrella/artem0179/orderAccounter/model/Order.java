/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.symmetrical_umbrella.artem0179.orderAccounter.model;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


/**
 *
 * @author рпи
 */
public class Order implements Serializable {
    private LocalDate startOfPrepareDate;
    private Client client;
    private List<Product> productList = new ArrayList<>();

    
    public Order() {
        
    }
    
    
    public Order(LocalDate startOfPrepareDate, Client client, List<Product> productList) {
        this.startOfPrepareDate = startOfPrepareDate;
        this.client = client;
        this.productList = productList;
    }
    
    
    public void addProduct(Product product) {
        productList.add(product);
    }
    
    public void delProduct(Product product) {
        productList.remove(product);
    }
    
    
    
}
