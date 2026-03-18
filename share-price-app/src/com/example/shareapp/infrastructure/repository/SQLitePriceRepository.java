package com.example.shareapp.infrastructure.repository;

import com.example.shareapp.domain.model.SharePrice;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class SQLitePriceRepository implements IPriceRepository {
    @Override
    public void savePrices(String symbol, List<SharePrice> prices) {
        // JDBC INSERT logic would go here
        System.out.println("DEBUG: Saving data to SQLite for " + symbol);
    }

    @Override
    public List<SharePrice> getPrices(String symbol, LocalDate start, LocalDate end) {
        // JDBC SELECT logic would go here
        System.out.println("DEBUG: Reading data from SQLite for " + symbol);
        return new ArrayList<>();
    }
}