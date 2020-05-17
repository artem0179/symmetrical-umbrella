/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.symmetrical_umbrella.artem0179.orderAccounter.model;

import java.io.Serializable;

/**
 *
 * @author рпи
 */
public class Product implements Serializable {
    private long article;
    private String name;
    private String diametr;
    private double price;
    private int stockBalance;

    
    public Product (long article, String name, String diametr, double price, int StockBalance) {
        this.article = article;
        this.name = name;
        this.diametr = diametr;
        this.price = price;
        this.stockBalance = StockBalance;
    }
    
    public void setArticle(long article) {
        this.article = article;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setColor(String diametr) {
        this.diametr = diametr;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setStockBalance(int stockBalance) {
        this.stockBalance = stockBalance;
    }
    
    @Override
    public String toString(){
        return this.getArticle() +";"+this.getName()+";"+this.getDiametr()+";"+this.getPrice();
    }

    /**
     * @return the article
     */
    public long getArticle() {
        return article;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @return the diametr
     */
    public String getDiametr() {
        return diametr;
    }

    /**
     * @return the price
     */
    public double getPrice() {
        return price;
    }

    /**
     * @return the stockBalance
     */
    public int getStockBalance() {
        return stockBalance;
    }
    
    

}
