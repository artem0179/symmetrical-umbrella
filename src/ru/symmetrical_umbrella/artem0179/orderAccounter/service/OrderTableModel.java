/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.symmetrical_umbrella.artem0179.orderAccounter.service;

import java.time.LocalDate;
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
public class OrderTableModel implements TableModel {
    private final String[] columnNames = {"Дата заказа", "Имя покупателя", "Скидка", "Адрес доставки", "Контактный телефон", "Статус заказа"};
    private final Class<?>[] columnTypes = {
        LocalDate.class,
        String.class,
        Integer.class,
        String.class,
        Integer.class,
        String.class,
    };
    private Order order;
    private Store store;
    private List<TableModelListener> listeners = new ArrayList<>(); 
    
    public OrderTableModel(Store store) {
        this.store = store;
                
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
        return store.getOrderList().size();
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        Order d = store.getOrderList().get(rowIndex);
        switch(columnIndex){
            case 0: return d.getStartOfPrepareDate();
            case 1: return d.getClient().getName();
            case 2: return d.getClient().getDiscount();
            case 3: return d.getClient().getDeliveryAdress();
            case 4: return d.getClient().getPhoneNumber();
            case 5: return "";

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
    
    

}

