package com.example.shareapp.domain.service;

import java.time.LocalDate;

/**
 * Interface for the main share service functionality[cite: 13, 72].
 */
public interface IShareService {
    /**
     * Compares two companies between two dates (max range 2 years)[cite: 20, 24].
     */
    void compareShares(String symbol1, String symbol2, LocalDate start, LocalDate end);
}