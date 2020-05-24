/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.symmetrical_umbrella.artem0179.orderAccounter.service;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Dialog;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
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
public class NewOrderDialog extends JDialog {

    public NewOrderDialog(Frame owner, boolean modal, Store store) {
        super(owner, modal);

        JPanel p = new JPanel();
        p.setLayout(new GridLayout(3, 2));
        
        
        JLabel a = new JLabel("Дата");
        p.add(a);
        
        JTextField textfield1 = new JTextField(10);
        p.add(textfield1);
        
        JLabel b = new JLabel("Имя");
        p.add(b);
        
        JTextField textfield2 = new JTextField(10);
        p.add(textfield2);
        
        Button btn = new Button("Создать");
        p.add(btn);
        btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                
                String[] data = textfield1.getText().split("\\.");
                LocalDate date = LocalDate.of(Integer.valueOf(data[2]), Integer.valueOf(data[1]), Integer.valueOf(data[0]));
                
                Client client = new Client(textfield2.getText(), "surname", "deliveryAdress", 35214524, 23);
                        
                
                Order order = new Order(date, client, new ArrayList<>());
                store.createOrder(order);
                
                dispose();
                
            }
        });
        
        
        add(p);
        //setSize(250, 400);
        pack();
        
        

    }


}
