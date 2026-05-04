package com.example.shareapp.domain.model;
public class StockPrice {

    private String date;
    private double price;

    public StockPrice(String date, double price) {
        this.date = date;
        this.price = price;
    }

    public String getDate() {
        return date;
    }

    public double getPrice() {
        return price;
    }
}