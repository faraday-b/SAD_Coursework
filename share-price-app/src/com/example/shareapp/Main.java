package com.example.shareapp;

import com.example.shareapp.client.controller.ShareController;
import com.example.shareapp.client.ui.GraphingUI;
import com.example.shareapp.client.ui.StyleManager;
import com.example.shareapp.domain.service.AnalyticsServiceImpl;
import com.example.shareapp.domain.service.ComparisonEngineImpl;
import com.example.shareapp.domain.service.ShareServiceImpl;
import com.example.shareapp.domain.validation.ShareValidator;
import com.example.shareapp.infrastructure.config.ConfigurationManager;
import com.example.shareapp.infrastructure.datasource.ExternalAPIConnector;
import com.example.shareapp.infrastructure.logging.LoggingService;
import com.example.shareapp.infrastructure.repository.PersistenceManager;
import com.example.shareapp.infrastructure.repository.SQLitePriceRepository;

/**
 * Main Application class that initializes the system architecture.
 * It coordinates the 'Starts' and 'Use' relations defined in the Component Diagram.
 */
public class Main {
    public static void main(String[] args) {
        // 1. Initialize Infrastructure & Configuration 
        ConfigurationManager config = new ConfigurationManager();
        LoggingService logger = new LoggingService();
        PersistenceManager persistenceManager = new PersistenceManager();
        persistenceManager.initializeStorage(); // Setup SQLite/JSON

        // 2. Initialize Data Access Layers 
        SQLitePriceRepository repository = new SQLitePriceRepository();
        ExternalAPIConnector apiConnector = new ExternalAPIConnector();
        // Note: apiConnector implements both IPriceDataSource and IAccess

        // 3. Initialize UI & Styles 
        GraphingUI ui = new GraphingUI();
        StyleManager styleManager = new StyleManager();
        styleManager.applyTheme(); // Apply basic styles as required 

        // 4. Initialize Domain Services (Business Logic) [cite: 60, 69]
        ShareValidator validator = new ShareValidator(); // Enforces 2-year range 
        ComparisonEngineImpl comparisonEngineImpl = new ComparisonEngineImpl();
        AnalyticsServiceImpl analyticsServiceImpl = new AnalyticsServiceImpl();

        // 5. Wire the Share Service Implementation 
        // This component implements IShareService and uses ILogging, IPriceRepository, etc.
        ShareServiceImpl shareService = new ShareServiceImpl(
                apiConnector,
                repository,
                validator,
                ui
        );

        // 6. Initialize the Controller
        ShareController controller = new ShareController(shareService);

        LocalDate startDate = LocalDate.now().minusMonths(1);
        LocalDate endDate = LocalDate.now();

        // 7. Demonstration of a System Request [cite: 19, 67]
        System.out.println("--- System Initialized (Sprint 2 Architecture) ---");
      controller.handleComparisonRequest("AAPL", "MSFT", startDate, endDate);

    }
}