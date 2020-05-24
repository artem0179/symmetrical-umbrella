/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.symmetrical_umbrella.artem0179.orderAccounter.service;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import ru.symmetrical_umbrella.artem0179.orderAccounter.model.Order;
import ru.symmetrical_umbrella.artem0179.orderAccounter.model.Product;



/**
 *
 * @author рпи
 */
public class Store {
    private List<Product> productList = new ArrayList<>();
    private List<Order> orderList = new ArrayList<>();
    private String fileDir; 

    public Store(String path) throws FileNotFoundException, IOException, ClassNotFoundException {        
        this.fileDir = path;
        
        productList.addAll(WriterReaderProductCSV.readerOrderCSV(path + File.separator + "reassesment.csv"));
        orderList.addAll(SerializacionDeserializacionOrderDAT.deserializationOrder(path + File.separator + "orders.dat"));
            // TODO: добавить в конструктор считывание заказов из файла аналогично продуктам

            
    }
    
    public Order createOrder(Order order) {
         
        orderList.add(order);
        
        try {
            SerializacionDeserializacionOrderDAT.serializationOrder(orderList, fileDir + File.separator + "orders.dat");
        } catch (IOException ex) {
            Logger.getLogger(Store.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return order;
    }
    
    public List<Product> getProductList() {
        return productList;
                
    }
        public List<Order> getOrderList() {
        return orderList;
                
    }
    
    
        
    
}
