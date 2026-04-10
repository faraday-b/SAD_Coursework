package com.example.shareapp.repository;

import com.example.shareapp.model.SharePrice;
import java.util.ArrayList;
import java.util.List;

/**
 * Temporary in-memory storage for Sprint 1.
 */
public class InMemoryPriceRepository implements PriceRepository {

    private List<SharePrice> storage = new ArrayList<>();

    @Override
    public List<SharePrice> findBySymbol(String symbol) {

        System.out.println("Repository: Retrieving data for " + symbol);

        // Sprint 1: no filtering yet
        return storage;
    }

    @Override
    public void save(SharePrice price) {
        storage.add(price);
    }
}
