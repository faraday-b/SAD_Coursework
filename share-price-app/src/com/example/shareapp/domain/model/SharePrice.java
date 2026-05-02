package com.example.shareapp.domain.model;

import java.time.LocalDate;

public class SharePrice {
    private String symbol;
    private double price;
    private LocalDate date;

    public SharePrice(String symbol, double price, LocalDate date) {
        this.symbol = symbol;
        this.price = price;
        this.date = date;
    }

    // Ensure these getters exist!
    public String getSymbol() { return symbol; }
    public double getPrice() { return price; }
    public LocalDate getDate() { return date; }
}