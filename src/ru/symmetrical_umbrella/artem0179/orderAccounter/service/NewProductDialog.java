/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.symmetrical_umbrella.artem0179.orderAccounter.service;

import java.awt.Button;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.util.ArrayList;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import ru.symmetrical_umbrella.artem0179.orderAccounter.model.Client;
import ru.symmetrical_umbrella.artem0179.orderAccounter.model.Order;
import ru.symmetrical_umbrella.artem0179.orderAccounter.model.Product;

/**
 *
 * @author рпи
 */
public class NewProductDialog extends JDialog {
    
     public NewProductDialog(Frame owner, boolean modal, Store store, Order order) {
        super(owner, modal);

        JPanel p = new JPanel();
        p.setLayout(new GridLayout(3, 2));
        
        
        JLabel a = new JLabel("Артикул");
        p.add(a);
        
        JTextField textfield1 = new JTextField(10);
        p.add(textfield1);
        
        JLabel b = new JLabel("Наименовавние");
        p.add(b);
        
        JTextField textfield2 = new JTextField(10);
        p.add(textfield2);
        
        Button btn = new Button("Создать");
        p.add(btn);
        btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                
                Product product = new Product(Long.valueOf(textfield1.getText()), textfield2.getText(), "colour", 0, 0);
                order.addProduct(product);
                
                dispose();
                owner.invalidate();
            }
        });
        
        
        add(p);
        //setSize(250, 400);
        pack();
        
        

    }
    
    
    
}
