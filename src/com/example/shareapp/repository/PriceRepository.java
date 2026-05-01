package com.example.shareapp.repository;

import com.example.shareapp.model.SharePrice;
import java.util.List;

/**
 * Repository abstraction.
 * Responsible for persistence operations.
 */
public interface PriceRepository {

    List<SharePrice> findBySymbol(String symbol);

    void save(SharePrice price);
}
