/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.symmetrical_umbrella.artem0179.orderAccounter.service;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import ru.symmetrical_umbrella.artem0179.orderAccounter.model.Order;

/**
 *
 * @author рпи
 */
public class SerializacionDeserializacionOrderDAT {
    
    
public static void serializationOrder(List<Order> orderList, String path) throws FileNotFoundException, IOException {
    File file = new File(path);
    FileOutputStream fos = new FileOutputStream(file);
    ObjectOutputStream oos = new ObjectOutputStream(fos);
    
    //for (Order o : orderList){
    oos.writeObject(orderList);
    //}
    
    oos.close();
}
    
public static List<Order> deserializationOrder(String path) throws FileNotFoundException, IOException, ClassNotFoundException {
    File file = new File(path); 
    
    FileInputStream fis = new FileInputStream(file);
       ObjectInputStream ois = null;
    try {
        ois = new ObjectInputStream(fis);
    } catch (EOFException e) {
        return new ArrayList<>();
    }
    
    
    List<Order> result = (List<Order>)ois.readObject();
    
    
    
    ois.close();
    
    return result;
}         
            
            

}
