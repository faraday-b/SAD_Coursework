package com.example.shareapp.controller;

// Compound component imports
import com.example.shareapp.visual.UIComponent;
import com.example.shareapp.logic.ValidationService;
import com.example.shareapp.logic.ComparisonEngine;
import com.example.shareapp.logic.AnalyticsService;
import com.example.shareapp.logic.ShareServiceImpl; // Explicitly from logic
   // The stable interface
import com.example.shareapp.data.LoggingService;
import java.time.LocalDate;

/**
 * Controller Layer.
 * Coordinates between UI, Logic, and Data groups.
 */
public class ShareController {
    private ValidationService validator = new ValidationService();
    private ComparisonEngine engine;
    private UIComponent ui = new UIComponent();
    private LoggingService logger = new LoggingService();

    public ShareController() {
        // FIX: Dependency Injection using the Logic implementation [cite: 89]
        // This coordinates the Brain (ComparisonEngine) with its dependencies
        this.engine = new ComparisonEngine(new ShareServiceImpl(), new AnalyticsService());
    }

    public void processStockRequest(String s1, String s2, LocalDate start, LocalDate end) {
        logger.logAction("Controller: Received comparison request for " + s1 + " and " + s2);
        
        // Enforce the 2-year range constraint via the Validation Service
        if (validator.validateDateRange(start, end)) {
            engine.compareStocks(s1, s2);
            ui.renderComparisonChart("Stock Performance Comparison", null);
        }
    }
}