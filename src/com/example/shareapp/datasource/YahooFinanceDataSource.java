package com.example.shareapp.datasource;

import com.example.shareapp.model.SharePrice;
import java.util.ArrayList;
import java.util.List;

/**
 * Placeholder for Yahoo Finance API integration.
 * Sprint 1: Simulated implementation.
 */
public class YahooFinanceDataSource implements PriceDataSource {

    @Override
    public List<SharePrice> fetchPrices(String symbol) {

        System.out.println("DataSource: Simulating API call for " + symbol);

        return new ArrayList<>();
    }
}
