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

    List<SharePrice> data = new ArrayList<>();

    double basePrice = symbol.equalsIgnoreCase("AAPL") ? 150 : 200;

    long days = java.time.temporal.ChronoUnit.DAYS.between(start, end);

    for (int i = 0; i < days; i += 30) {
        data.add(new SharePrice(start.plusDays(i), basePrice + (i * 0.5)));
    }

    return data;
}
}