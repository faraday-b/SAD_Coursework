package com.example.shareapp.domain.service;

import com.example.shareapp.domain.model.SharePrice;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ComparisonEngine implements IComparison {
    @Override
    public Map<String, Double> calculateGrowth(Map<String, List<SharePrice>> data) {
        Map<String, Double> growthMap = new HashMap<>();

        data.forEach((symbol, prices) -> {
            if (prices != null && prices.size() >= 2) {
                double startPrice = prices.get(0).getClosePrice();
                double endPrice = prices.get(prices.size() - 1).getClosePrice();
                double growth = ((endPrice - startPrice) / startPrice) * 100;
                growthMap.put(symbol, growth);
            }
        });
        return growthMap;
    }
}