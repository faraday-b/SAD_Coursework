package com.example.shareapp.domain.service;

import com.example.shareapp.client.ui.IVisualise;
import com.example.shareapp.domain.model.SharePrice;
import com.example.shareapp.domain.validation.IValidator;
import com.example.shareapp.infrastructure.datasource.IPriceDataSource;
import com.example.shareapp.infrastructure.repository.IPriceRepository;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ShareServiceImpl implements IShareService {
    private final IPriceDataSource dataSource;
    private final IPriceRepository repository;
    private final IValidator validator;
    private final IVisualise ui;

    public ShareServiceImpl(IPriceDataSource ds, IPriceRepository repo, IValidator val, IVisualise ui) {
        this.dataSource = ds;
        this.repository = repo;
        this.validator = val;
        this.ui = ui;
    }

    @Override
    public void compareShares(String s1, String s2, LocalDate start, LocalDate end) {
        // 1. Validate date range (Max 2 years)
        if (!validator.isValidRange(start, end)) {
            ui.displayError("Invalid date range. Maximum range is 2 years.");
            return;
        }

        Map<String, List<SharePrice>> results = new HashMap<>();

        // 2. Business logic: Fetch data for both symbols [cite: 24]
        results.put(s1, fetchData(s1, start, end));
        results.put(s2, fetchData(s2, start, end));

        // 3. Return results to UI via interface
        ui.displayComparison(results);
    }

    private List<SharePrice> fetchData(String symbol, LocalDate start, LocalDate end) {
        // Attempt to get from persistent storage first for offline functionality
        List<SharePrice> cached = repository.getPrices(symbol, start, end);
        if (cached != null && !cached.isEmpty()) {
            return cached;
        }
        // Otherwise, fetch from external API
        List<SharePrice> remote = dataSource.fetchPrices(symbol, start, end);
        repository.savePrices(symbol, remote); // Store for persistence
        return remote;
    }
}