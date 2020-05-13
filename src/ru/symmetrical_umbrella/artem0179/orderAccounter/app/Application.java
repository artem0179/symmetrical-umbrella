/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.symmetrical_umbrella.artem0179.orderAccounter.app;

import ru.symmetrical_umbrella.artem0179.orderAccounter.model.Order;
import ru.symmetrical_umbrella.artem0179.orderAccounter.model.Product;
import ru.symmetrical_umbrella.artem0179.orderAccounter.service.Store;

/**
 *
 * @author рпи
 */
public class Application {
    
    public static void main(String[] args) {
        
        Store store = new Store();
        
        store.init();
        Order order = store.createOrder();
        
        System.out.println(store.getProductList());
        
        Product p = new Product(123, "Pizza", "Green", 23, 10);
        order.addProduct(p);
    }
}
