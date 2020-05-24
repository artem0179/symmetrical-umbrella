/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.symmetrical_umbrella.artem0179.orderAccounter.service;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import ru.symmetrical_umbrella.artem0179.orderAccounter.model.Product;

/**
 *
 * @author рпи
 */
public class WriterReaderProductCSV {


public static List<Product> readerOrderCSV(String filePath) throws FileNotFoundException {
    Scanner scanner = new Scanner(new File(filePath));
    List<Product> result = new ArrayList<>();
    
    while(scanner.hasNextLine()) {

        String line = (scanner.nextLine());
        String[] dataCSV = line.split(";");
        long art = Long.parseLong(dataCSV[0]);
        double price = Double.parseDouble(dataCSV[3]);
        int amm = Integer.parseInt(dataCSV[4]);
        Product product = new Product(art, dataCSV[1], dataCSV[2], price, amm);
        result.add(product);
    
    }
    scanner.close();
    
    return result;
    

    
    }    
public static void writerOrderSCV(String filePath, List<Product> productList) throws FileNotFoundException {
    PrintWriter writer = new PrintWriter(new File(filePath));
    
     
    for (Product p : productList){
        String a;
        a = p.getArticle() +";"+p.getName()+";"+p.getColour()+";"+p.getPrice()+";"+p.getStockBalance();
        writer.println(a);
        
    }
    
    
    writer.close();
}

}    
    
  
    
