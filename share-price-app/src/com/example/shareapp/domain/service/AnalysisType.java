package com.example.shareapp.domain.service;

/**
 * Supports scalability by allowing the Analytics Service to
 * handle multiple calculation types.
 */
public enum AnalysisType {
    AVERAGE_PRICE,
    MAX_PRICE,
    MIN_PRICE,
    VOLATILITY,
    SIMPLE_MOVING_AVERAGE
}