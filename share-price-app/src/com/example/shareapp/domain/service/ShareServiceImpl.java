package com.example.shareapp.domain.service;

import com.example.shareapp.domain.model.ComparisonResult;
import com.example.shareapp.domain.model.SharePrice;
import com.example.shareapp.domain.validation.IValidator;
import com.example.shareapp.infrastructure.repository.IPriceRepository;
import com.example.shareapp.client.ui.IVisualise;
import java.time.LocalDate;
import java.util.List;

public class ShareServiceImpl implements IShareService {
    private final IPriceRepository repository;
    private final IValidator validator;
    private final IAnalytics analytics;
    private final IComparison comparisonEngine;
    private final IVisualise ui;

    // CONSTRUCTOR ORDER: Repository, Validator, Analytics, Engine, UI
    public ShareServiceImpl(IPriceRepository repo, IValidator val, IAnalytics anal, IComparison comp, IVisualise ui) {
        this.repository = repo;
        this.validator = val;
        this.analytics = anal;
        this.comparisonEngine = comp;
        this.ui = ui;
    }

    @Override
    public ServiceResponse<ComparisonResult> compareShares(String s1, String s2, LocalDate start, LocalDate end) {
        // Business Rule Check
        if (!validator.isValidRange(start, end)) {
            return ServiceResponse.error("Invalid range: Max 2 years.");
        }

        // Data Fetching
        List<SharePrice> dataA = repository.getPrices(s1, start, end);
        List<SharePrice> dataB = repository.getPrices(s2, start, end);

        // --- ADD THIS MOCK DATA BLOCK FOR TESTING ---
        if (dataA.isEmpty()) {
            dataA = java.util.List.of(new SharePrice(s1, 150.0, start), new SharePrice(s1, 160.0, end));
        }
        if (dataB.isEmpty()) {
            dataB = java.util.List.of(new SharePrice(s2, 140.0, start), new SharePrice(s2, 155.0, end));
        }
        // --------------------------------------------

        if (dataA.isEmpty() || dataB.isEmpty()) {
            return ServiceResponse.error("Missing data for comparison.");
        }

        System.out.println("[Service] Data found for " + s1 + ": " + dataA.size() + " points");
        System.out.println("[Service] Data found for " + s2 + ": " + dataB.size() + " points");

        if (dataA.isEmpty() || dataB.isEmpty()) {
            System.out.println("[Service] ERROR: Stopping because data is missing.");
            return ServiceResponse.error("Missing data for comparison.");
        }

        // Logic Filter
        ComparisonResult result = comparisonEngine.compare(dataA, dataB);

        // UI Update
        ui.displayComparison(result.getComparisonText());

        // Trigger the visual windows
        ui.renderComparisonChart(s1 + " Prices", dataA);
        ui.renderComparisonChart(s2 + " Prices", dataB);

        return ServiceResponse.ok(result);
    }
}