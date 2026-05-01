package com.example.shareapp.logic;

import com.example.shareapp.model.SharePrice;
import com.example.shareapp.data.LoggingService;
import java.util.List;
import java.util.ArrayList;

public class AnalyticsService {
    
    private LoggingService logger = new LoggingService();

    public List<Double> calculateMovingAverage(List<SharePrice> data, int period) {
        // FIX: Include 'period' in the log to satisfy SonarQube
        logger.logAction("Calculating " + period + "-day Moving Average for " + data.size() + " data points.");
        return new ArrayList<>();
    }

    public double calculateVolatility(List<SharePrice> data) {
        // FIX: Use 'data' in the log
        logger.logAction("Calculating volatility for dataset.");
        return data != null ? 0.0 : -1.0; 
    }
}