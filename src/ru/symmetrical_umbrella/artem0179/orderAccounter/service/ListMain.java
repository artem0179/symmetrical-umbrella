/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.symmetrical_umbrella.artem0179.orderAccounter.service;

import static com.sun.javafx.fxml.expression.Expression.add;
import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JSplitPane;
import javax.swing.JTable;
import javax.swing.JToolBar;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author рпи
 */
public class ListMain extends JFrame {

    private JTable orders;
    private JTable orderItems;

    //private Store store;

    public ListMain(Store store) {

        super("Магазин на диване");
        setBounds(300, 200, 900, 600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        //this.store = store;


        add(new JSplitPane(JSplitPane.VERTICAL_SPLIT, getTopPanel(), getBottomPanel()));
    }

    private JPanel getTopPanel() {
        JPanel top = new JPanel(new BorderLayout());
        JToolBar topTB = new JToolBar();
        topTB.add(new JButton("Создать заказ"));
        top.add(topTB, BorderLayout.NORTH);


        
        orders = new JTable(new Object[][]{},
                new String[]{
                    "Дата заказа",
                    "Имя покупателя",
                    "Скидка",
                    "Адресс доставки",
                    "Контактный телефон",
                    "Статус заказа",});

        JPanel topTblPnl = new JPanel(new BorderLayout());
        topTblPnl.add(orders.getTableHeader(), BorderLayout.NORTH);
        topTblPnl.add(orders, BorderLayout.CENTER);

        top.add(topTblPnl, BorderLayout.CENTER);
        
        
        

        
        return top;
    }
    
    
    private JPanel getBottomPanel() {
                JPanel bottom = new JPanel(new BorderLayout());
        JToolBar bottomTB = new JToolBar();
        bottomTB.add(new JButton("Добавить позицию в заказ"));
        bottomTB.add(new JButton("Удалить позицию из заказа"));
        bottom.add(bottomTB, BorderLayout.NORTH);

        orderItems = new JTable(new Object[][]{},
                new String[]{
                    "Артикул",
                    "Наименование",
                    "Цена за ед.",
                    "Количество",
                    "Итого"});

        JPanel bottomTblPnl = new JPanel(new BorderLayout());
        bottomTblPnl.add(orderItems.getTableHeader(), BorderLayout.NORTH);
        bottomTblPnl.add(orderItems, BorderLayout.CENTER);

        bottom.add(bottomTblPnl, BorderLayout.CENTER);
        
        return bottom;
    }
}


