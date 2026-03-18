package com.example.shareapp.infrastructure.datasource;

import com.example.shareapp.domain.model.SharePrice;
import com.example.shareapp.infrastructure.repository.IPriceRepository;
import java.time.LocalDate;
import java.util.List;

public class DataProvider {
    private final IPriceDataSource apiConnector;
    private final IPriceRepository repository;

    public DataProvider(IPriceDataSource api, IPriceRepository repo) {
        this.apiConnector = api;
        this.repository = repo;
    }

    public List<SharePrice> resolveData(String symbol, LocalDate start, LocalDate end) {
        // First check local persistence (Requirement: Offline functionality)
        List<SharePrice> cached = repository.getPrices(symbol, start, end);
        if (cached != null && !cached.isEmpty()) {
            return cached;
        }
        // If not found, fetch from API and save to local storage
        List<SharePrice> remote = apiConnector.fetchPrices(symbol, start, end);
        repository.savePrices(symbol, remote);
        return remote;
    }
}