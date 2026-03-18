package com.example.shareapp.client.ui;

import com.example.shareapp.domain.model.SharePrice;
import java.util.List;
import java.util.Map;

public class GraphingUI implements IVisualise {

    @Override
    public void displayComparison(Map<String, List<SharePrice>> data) {
        System.out.println("--- Comparison Result ---");
        data.forEach((symbol, prices) -> {
            System.out.println("Company: " + symbol + " | Records: " + prices.size());
            // In Sprint 3, this will feed into a graphing library.
        });
    }

    @Override
    public void displayError(String message) {
        System.err.println("Error: " + message);
    }
}