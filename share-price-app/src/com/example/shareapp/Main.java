package com.example.shareapp;

// Import the Controller
import com.example.shareapp.client.controller.ShareController;
// Import the UI
import com.example.shareapp.client.ui.GraphingUI;
// Import the Services and Interfaces
import com.example.shareapp.domain.service.*;
// Import the Validator
import com.example.shareapp.domain.validation.ShareValidator;
// Import the Infrastructure components
import com.example.shareapp.infrastructure.config.ConfigurationManager;
import com.example.shareapp.infrastructure.datasource.DataProvider;
import com.example.shareapp.infrastructure.datasource.ExternalAPIConnector;
import com.example.shareapp.infrastructure.repository.SQLitePriceRepository;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        System.out.println("===========================================");
        System.out.println("   SHARE PRICE ANALYSIS SYSTEM - STARTING  ");
        System.out.println("===========================================");

        try {
            // 1. INFRASTRUCTURE SETUP
            // ConfigurationManager provides the DB path and API keys
            ConfigurationManager config = new ConfigurationManager();

            // SQLitePriceRepository handles local database storage
            SQLitePriceRepository repository = new SQLitePriceRepository();

            // ExternalAPIConnector handles fetching from the web
            ExternalAPIConnector apiConnector = new ExternalAPIConnector();

            // DataProvider orchestrates the "Offline Functionality"
            DataProvider dataProvider = new DataProvider(apiConnector, repository);

            // 2. DOMAIN LOGIC SETUP (Your individual contribution area)
            ShareValidator validator = new ShareValidator();
            AnalyticsServiceImpl analytics = new AnalyticsServiceImpl();
            ComparisonEngineImpl comparison = new ComparisonEngineImpl();

            // 3. UI SETUP
            GraphingUI ui = new GraphingUI();

            // 4. COMPOSITION ROOT (The "Wiring" of the components)
            // Note: We use the repository here so the service can read/write data
            ShareServiceImpl shareService = new ShareServiceImpl(
                    repository,
                    validator,
                    analytics,
                    comparison,
                    ui
            );

            // 5. CONTROLLER SETUP
            ShareController controller = new ShareController(shareService);

            // 6. EXECUTION
            // Let's compare Apple (AAPL) and Microsoft (MSFT) for the last 30 days
            String stockA = "AAPL";
            String stockB = "MSFT";
            LocalDate endDate = LocalDate.now();
            LocalDate startDate = endDate.minusDays(30);

            System.out.println("[Main] Requesting comparison for " + stockA + " vs " + stockB);

            // This triggers the full Pipe and Filter chain!
            controller.handleComparisonRequest(stockA, stockB, startDate, endDate);

        } catch (Exception e) {
            System.err.println("[Critical Error] Application failed: " + e.getMessage());
            e.printStackTrace();
        }
    }
}