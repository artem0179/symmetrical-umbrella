/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.symmetrical_umbrella.artem0179.orderAccounter.service;

import java.util.ArrayList;
import java.util.List;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;
import ru.symmetrical_umbrella.artem0179.orderAccounter.model.Order;
import ru.symmetrical_umbrella.artem0179.orderAccounter.model.Product;

/**
 *
 * @author рпи
 */
public class ProductTableModel implements TableModel {
    private final String[] columnNames = {"Артикул", "Наименование", "Цвет", "Цена за ед.", "Кол-во", "Итого"};
    private final Class<?>[] columnTypes = {
        Long.class,
        String.class,
        String.class,
        Integer.class,
        Integer.class,
        Integer.class,
    };
    private Order order;
    
    private List<TableModelListener> listeners = new ArrayList<>(); 
    
    public ProductTableModel(Order order) {
        this.order = order;
                
    }
    
    public void setOrder(Order order) {
        this.order = order;
    }
    

    @Override
    public int getColumnCount() {
        return columnNames.length;
    }

    @Override
    public String getColumnName(int columnIndex) {
        return columnNames[columnIndex];
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        return columnTypes[columnIndex];
    }
    
        @Override
    public int getRowCount() {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        return order!= null? order.getProductList().size():0;
        
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        Product d = order.getProductList().get(rowIndex);
        switch(columnIndex){
            case 0: return d.getArticle();
            case 1: return d.getName();
            case 2: return d.getColour();
            case 3: return d.getPrice();
            case 4: return 10;
            case 5: return (d.getPrice() * 10);
            default: 
                throw  new Error("Unreachable place.");
        }
        
    }
    
    
    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return false;

    }


    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void addTableModelListener(TableModelListener l) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        listeners.add(l);
    }

    @Override
    public void removeTableModelListener(TableModelListener l) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        listeners.remove(l);
    }
    
    public void addProductRow() {
        
    }
    
    public boolean removeProductRow() {
        return false;
    }
    

}
