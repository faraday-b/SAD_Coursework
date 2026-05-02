package com.example.shareapp.domain.service;

import com.example.shareapp.domain.model.ComparisonResult;
import com.example.shareapp.domain.model.SharePrice;
import java.util.HashMap;
import java.util.List;

public class ComparisonEngineImpl implements IComparison {

    @Override
    public ComparisonResult compare(List<SharePrice> listA, List<SharePrice> listB) {
        if (listA.isEmpty() || listB.isEmpty()) {
            return new ComparisonResult("N/A", "N/A", 0, 0, new HashMap<>());
        }

        // Logic: Compare latest prices
        double priceA = listA.get(listA.size() - 1).getPrice();
        double priceB = listB.get(listB.size() - 1).getPrice();

        double diff = priceA - priceB;
        double percent = (priceA / priceB) * 100;

        // In a real SOA, you'd calculate correlation here
        return new ComparisonResult(
                listA.get(0).getSymbol(),
                listB.get(0).getSymbol(),
                diff,
                percent,
                new HashMap<>()
        );
    }
}