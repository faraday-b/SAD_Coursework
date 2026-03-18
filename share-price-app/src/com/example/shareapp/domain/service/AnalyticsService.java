package com.example.shareapp.domain.service;

import com.example.shareapp.domain.model.SharePrice;
import java.util.List;

public class AnalyticsService implements IAnalytics {
    @Override
    public double calculateAverage(List<SharePrice> prices) {
        return prices.stream()
                .mapToDouble(SharePrice::getClosePrice)
                .average()
                .orElse(0.0);
    }
}