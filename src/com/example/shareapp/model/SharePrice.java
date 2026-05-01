package com.example.shareapp.model;

import java.time.LocalDate;

/**
 * Represents a daily share price record.
 */
public class SharePrice {

    private String symbol;
    private LocalDate date;
    private double closingPrice;

    public SharePrice(String symbol, LocalDate date, double closingPrice) {
        this.symbol = symbol;
        this.date = date;
        this.closingPrice = closingPrice;
    }

    public String getSymbol() {
        return symbol;
    }

    public LocalDate getDate() {
        return date;
    }

    public double getClosingPrice() {
        return closingPrice;
    }
}
