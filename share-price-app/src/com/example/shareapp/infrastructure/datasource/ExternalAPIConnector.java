package com.example.shareapp.infrastructure.datasource;

import com.example.shareapp.domain.model.SharePrice;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class ExternalAPIConnector implements IAccess, IPriceDataSource {

    @Override
    public List<SharePrice> accessExternalData(String symbol, LocalDate start, LocalDate end) {
        // This maps to the IAccess requirement in the diagram
        return fetchPrices(symbol, start, end);
    }

    @Override
    public List<SharePrice> fetchPrices(String symbol, LocalDate start, LocalDate end) {
        System.out.println("[API] Accessing external financial data for: " + symbol);
        return new ArrayList<>(); // Placeholder for Sprint 2
    }
}