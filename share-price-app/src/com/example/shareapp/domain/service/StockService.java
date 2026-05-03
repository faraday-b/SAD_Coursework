package com.example.shareapp.domain.service;
import com.example.shareapp.domain.model.StockPrice;
import java.util.ArrayList;
import java.util.List;

public class StockService {

  public List<StockPrice> fetchStockData(String symbol, String start, String end) {
    System.out.println("🔥 MY STOCK SERVICE IS RUNNING");
    List<StockPrice> data = new ArrayList<>();

    data.add(new StockPrice("2024-01-01", 150.0));
    data.add(new StockPrice("2024-01-02", 152.5));
    data.add(new StockPrice("2024-01-03", 149.8));

    return data;
}