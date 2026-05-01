package com.example.shareapp.domain.service;

import com.example.shareapp.domain.model.SharePrice;
import java.util.List;

/**
 * Implementation of the Analytics Filter for the Stock & Logic component.
 * Supports scalability by handling various calculation types.
 */
public class AnalyticsServiceImpl implements IAnalytics {

    @Override
    public double calculate(List<SharePrice> prices, AnalysisType type) {
        if (prices == null || prices.isEmpty()) {
            return 0.0;
        }

        switch (type) {
            case AVERAGE_PRICE:
                return prices.stream()
                        .mapToDouble(SharePrice::getPrice)
                        .average()
                        .orElse(0.0);

            case MAX_PRICE:
                return prices.stream()
                        .mapToDouble(SharePrice::getPrice)
                        .max()
                        .orElse(0.0);

            case VOLATILITY:
                return calculateVolatility(prices);

            default:
                // This ensures interoperability - if a type isn't supported yet, it doesn't crash the system
                System.out.println("[WARNING] Analysis type not supported: " + type);
                return 0.0;
        }
    }

    private double calculateVolatility(List<SharePrice> prices) {
        double average = calculate(prices, AnalysisType.AVERAGE_PRICE);
        double variance = prices.stream()
                .mapToDouble(p -> Math.pow(p.getPrice() - average, 2))
                .average()
                .orElse(0.0);
        return Math.sqrt(variance);
    }
}