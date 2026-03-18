package com.example.shareapp.domain.model;

public class Company {
    private final String symbol;
    private final String name;

    public Company(String symbol, String name) {
        this.symbol = symbol;
        this.name = name;
    }

    public String getSymbol() { return symbol; }
    public String getName() { return name; }
}