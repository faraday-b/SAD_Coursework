package com.example.shareapp.logic;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import com.example.shareapp.data.LoggingService;

public class ValidationService {
    private LoggingService logger = new LoggingService();

    public boolean validateDateRange(LocalDate start, LocalDate end) {
        long days = ChronoUnit.DAYS.between(start, end);
        // Requirement: Enforce a maximum date range of two years (approx. 730 days)
        boolean isValid = days >= 0 && days <= 730;
        
        if (!isValid) {
            logger.logAction("Validation Failed: Date range " + days + " days exceeds 2-year limit.");
        }
        return isValid;
    }
}