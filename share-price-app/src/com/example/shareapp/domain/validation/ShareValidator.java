package com.example.shareapp.domain.validation;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class ShareValidator implements IValidator {
    @Override
    public boolean isValidRange(LocalDate start, LocalDate end) {
        if (start == null || end == null) return false;
        if (start.isAfter(end)) return false;

        // Requirement: Maximum range of two years
        long daysBetween = ChronoUnit.DAYS.between(start, end);
        return daysBetween <= 730; // 365 * 2
    }
}