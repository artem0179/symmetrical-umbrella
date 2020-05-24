/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.symmetrical_umbrella.artem0179.orderAccounter.service;

import static com.sun.javafx.fxml.expression.Expression.add;
import java.awt.BorderLayout;
import java.awt.ScrollPane;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTable;
import javax.swing.JToolBar;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import ru.symmetrical_umbrella.artem0179.orderAccounter.model.Order;

/**
 *
 * @author рпи
 */
public class ListMain extends JFrame {

    //private JTable orders;
    //private JTable orderItems;
    Order curOrder;

    JPanel bottomPanel;
    JSplitPane pane ;
    ProductTableModel tableModel;
    JTable bottomTable;
    public ListMain(Store store) {

        super("Магазин на диване");
        setBounds(300, 200, 900, 600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        //add(tbl, BorderLayout.CENTER);
        //add(tbl.getTableHeader(), BorderLayout.NORTH);
        bottomPanel = getBottomPanel(store);
        pane = new JSplitPane(JSplitPane.VERTICAL_SPLIT, getTopPanel(store), bottomPanel);
       
        add(pane);
    }

    private JPanel getTopPanel(Store store) {
        OrderTableModel tableModel = new OrderTableModel(store);
        JTable tbl = new JTable(tableModel);

        tbl.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        ListSelectionModel selectionModel = tbl.getSelectionModel();

        selectionModel.addListSelectionListener(new ListSelectionListener() {
            public void valueChanged(ListSelectionEvent e) {
        
                
                
            ListSelectionModel lsm = (ListSelectionModel)e.getSource();

                int firstIndex = e.getFirstIndex();
                int lastIndex = e.getLastIndex();
                int minIndex = lsm.getMinSelectionIndex();
                int maxIndex = lsm.getMaxSelectionIndex();
                for (int i = minIndex; i <= maxIndex; i++) {
                if (lsm.isSelectedIndex(i)) {
                    curOrder = store.getOrderList().get(i);
                    ListMain.this.tableModel.setOrder(curOrder);

                }
                
            }
        


            }
        });

        JPanel top = new JPanel(new BorderLayout());
        JToolBar topTB = new JToolBar();

        JButton addOrdeBtn = new JButton("Создать заказ");
        topTB.add(addOrdeBtn);
        addOrdeBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                NewOrderDialog dialog = new NewOrderDialog(ListMain.this, true, store);

                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        //System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }

        });

        top.add(topTB, BorderLayout.NORTH);

        JPanel topTblPnl = new JPanel(new BorderLayout());
        topTblPnl.add(tbl.getTableHeader(), BorderLayout.NORTH);
        topTblPnl.add(tbl, BorderLayout.CENTER);

        top.add(topTblPnl, BorderLayout.CENTER);

        return top;
    }

    private JPanel getBottomPanel(Store store) {
        tableModel = new ProductTableModel(curOrder);
        bottomTable = new JTable(tableModel);

        JPanel bottom = new JPanel(new BorderLayout());
        JToolBar bottomTB = new JToolBar();

        JButton addPositionOrder = new JButton("Добавить позицию в заказ");
        bottomTB.add(addPositionOrder);
        addPositionOrder.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                NewProductDialog dialog = new NewProductDialog(ListMain.this, true, store, curOrder);

                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        //System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });

        JButton remPositionOrder = new JButton("Удалить позицию из заказа");
        bottomTB.add(remPositionOrder);
        remPositionOrder.addActionListener(e -> {
            if (!tableModel.removeProductRow()) {
                JOptionPane.showMessageDialog(this, "Позиции в заказе отсутствуют.", "Error", JOptionPane.INFORMATION_MESSAGE);
            }
        });

        bottom.add(bottomTB, BorderLayout.NORTH);

        JPanel bottomTblPnl = new JPanel(new BorderLayout());
        bottomTblPnl.add(bottomTable.getTableHeader(), BorderLayout.NORTH);
        bottomTblPnl.add(new JScrollPane(bottomTable), BorderLayout.CENTER);

        bottom.add(bottomTblPnl, BorderLayout.CENTER);

        return bottom;
    }
}
