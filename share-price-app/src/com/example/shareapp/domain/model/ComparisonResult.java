package com.example.shareapp.domain.model;

import java.util.Map;

/**
 * Encapsulates comparison logic results for interoperability.
 */
public class ComparisonResult {
    private final String symbolA;
    private final String symbolB;
    private final double priceDifference;
    private final double percentageChange;
    private final Map<String, Double> correlationData;

    public ComparisonResult(String s1, String s2, double diff, double percent, Map<String, Double> correlation) {
        this.symbolA = s1;
        this.symbolB = s2;
        this.priceDifference = diff;
        this.percentageChange = percent;
        this.correlationData = correlation;
    }

    public String getComparisonText() {
        return String.format("%s vs %s: Difference of %.2f (%.2f%%)", symbolA, symbolB, priceDifference, percentageChange);
    }
}