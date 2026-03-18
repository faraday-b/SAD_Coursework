package com.example.shareapp.domain.validation;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public interface IValidator {
    default boolean isValidRange(LocalDate start, LocalDate end) {
        if (start == null || end == null) return false;
        long years = ChronoUnit.YEARS.between(start, end);
        return years <= 2 && !start.isAfter(end); // Max range 2 years
    }
}