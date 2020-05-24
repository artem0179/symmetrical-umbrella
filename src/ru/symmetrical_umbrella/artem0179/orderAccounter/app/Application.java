/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.symmetrical_umbrella.artem0179.orderAccounter.app;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Properties;
import java.util.Scanner;
import ru.symmetrical_umbrella.artem0179.orderAccounter.model.Client;
import ru.symmetrical_umbrella.artem0179.orderAccounter.model.Order;
import ru.symmetrical_umbrella.artem0179.orderAccounter.model.Product;
import ru.symmetrical_umbrella.artem0179.orderAccounter.service.ListMain;
import ru.symmetrical_umbrella.artem0179.orderAccounter.service.SerializacionDeserializacionOrderDAT;
import ru.symmetrical_umbrella.artem0179.orderAccounter.service.Store;
import ru.symmetrical_umbrella.artem0179.orderAccounter.service.WriterReaderProductCSV;

/**
 *
 * @author рпи
 */
public class Application {
    
    
    
    public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException {
        
     
        
        String separator = File.separator;

    
        Properties p = new Properties();
        p.load(new InputStreamReader(new FileInputStream(args[0]),"UTF8"));
        String path = p.getProperty("filedir");
        
        Store store = new Store(path);
        new ListMain(store).setVisible(true);

        //Order order = store.createOrder();
        
       
        

        
    }    
    
    
}
    
    

