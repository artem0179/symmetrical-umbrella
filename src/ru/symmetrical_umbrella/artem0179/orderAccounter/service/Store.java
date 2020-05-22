/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.symmetrical_umbrella.artem0179.orderAccounter.service;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
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

    public Store(String path) throws FileNotFoundException {        
        this.fileDir = path;
        productList.addAll(WriterReaderProductCSV.readerOrderCSV(path));
        
            // TODO: добавить в конструктор считывание заказов из файла аналогично продуктам

            
    }
    
    public Order createOrder() {
        Order order = new Order();
                //заказ с пустым списком товаров и статусом готовится
        orderList.add(order);
                // дописываем заказ в файл dat
        return order;
    }
    
    public List<Product> getProductList() {
        return productList;
                
    }
    
    
    
}
