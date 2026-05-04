package com.example.shareapp.client.controller;

import java.util.List;
import com.example.shareapp.domain.service.StockService;
import com.example.shareapp.domain.model.StockPrice;

public class StockController {

    private StockService stockService;

    public StockController() {
        this.stockService = new StockService();
    }

    public List<StockPrice> getStockData(String symbol, String startDate, String endDate) {
        return stockService.fetchStockData(symbol, startDate, endDate);
    }
}