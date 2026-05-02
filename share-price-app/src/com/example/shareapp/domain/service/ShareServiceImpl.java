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

    public ShareServiceImpl(IPriceRepository repo, IValidator val, IAnalytics anal, IComparison comp, IVisualise ui) {
        this.repository = repo;
        this.validator = val;
        this.analytics = anal;
        this.comparisonEngine = comp;
        this.ui = ui;
    }

    @Override
    public ServiceResponse<ComparisonResult> compareShares(String s1, String s2, LocalDate start, LocalDate end) {
        // FILTER 1: Validation (Business Rule: 2-year max)
        if (!validator.isValidRange(start, end)) {
            return ServiceResponse.error("Invalid date range: Maximum 2 years allowed.");
        }

        // FILTER 2: Data Fetching (Persistence/Offline Support)
        List<SharePrice> dataA = repository.getPrices(s1, start, end);
        List<SharePrice> dataB = repository.getPrices(s2, start, end);

        if (dataA.isEmpty() || dataB.isEmpty()) {
            return ServiceResponse.error("No data found for one or both symbols.");
        }

        // FILTER 3: Analytics (Technical Analysis)
        double avgA = analytics.calculate(dataA, AnalysisType.AVERAGE_PRICE);
        double volA = analytics.calculate(dataA, AnalysisType.VOLATILITY);

        // FILTER 4: Comparison (Generating Compound Result)
        ComparisonResult result = comparisonEngine.compare(dataA, dataB);

        // UI NOTIFICATION: Visualizing components
        ui.displayComparison(result.getComparisonText());

        // SOA WRAPPER: Final Interoperable Result
        return ServiceResponse.ok(result);
    }
}