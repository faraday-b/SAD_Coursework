package com.example.shareapp.domain.model;

import java.time.LocalDate;

/**
 * Represents daily price information as required by the spec.
 */
public class SharePrice {
    private final LocalDate date;
    private final double closePrice;

    public SharePrice(LocalDate date, double closePrice) {
        this.date = date;
        this.closePrice = closePrice;
    }

    public LocalDate getDate() { return date; }
    public double getClosePrice() { return closePrice; }
}