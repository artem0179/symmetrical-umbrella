/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.symmetrical_umbrella.artem0179.orderAccounter.service;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;
import ru.symmetrical_umbrella.artem0179.orderAccounter.model.Product;

/**
 *
 * @author рпи
 */
public class WriterReaderOrderCSV {

    String separator = File.separator;
    String path = "C:" + separator + "Users" + separator + "рпи" + separator + 
            "Documents" + separator + "NetBeansProjects" + separator + "Lab5" + 
            separator + "Test.csv";
    File file = new File(path);

public void readerOrderCSV() throws FileNotFoundException {
    Scanner scanner = new Scanner(file);
    String line = scanner.nextLine();
    String[] dataSCV = line.split(";");
    
    System.out.println("привет из ридера"/*Arrays.toString(dataSCV)*/);
    
    scanner.close();
    }    
public void writerOrderSCV(Product p) throws FileNotFoundException {
    PrintWriter writer = new PrintWriter(file);
    
    writer.println(p);
    
    System.out.println("привет из райтера" + Arrays.toString(p));
    writer.close();
}

}    
    
  
    
