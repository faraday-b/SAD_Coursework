package com.example.shareapp.controller;

import java.time.LocalDate;

/**
 * Entry point of the Share Price Comparison Application.
 * Sprint 1: Demonstrates layered architecture structure.
 */
public class Main {

    public static void main(String[] args) {

        ShareController controller = new ShareController();
        
        // FIX: Changed compareShares to processStockRequest to match new Controller
        // Added dummy dates to satisfy the ValidationService logic
        LocalDate start = LocalDate.now().minusYears(1);
        LocalDate end = LocalDate.now();
        
        controller.processStockRequest("AAPL", "MSFT", start, end);
    }
}

