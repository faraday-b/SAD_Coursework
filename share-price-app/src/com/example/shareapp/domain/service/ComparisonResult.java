package com.example.shareapp.domain.model;

import java.util.Map;

/**
 * A compound data object representing the result of a comparison.
 * Supports interoperability between the Logic and UI layers.
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

    // Getters for the UI to consume
    public String getComparisonText() {
        return String.format("%s vs %s: Difference of %.2f (%.2f%%)", symbolA, symbolB, priceDifference, percentageChange);
    }
}