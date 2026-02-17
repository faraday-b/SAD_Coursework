package com.example.shareapp.datasource;

import com.example.shareapp.model.SharePrice;
import java.util.List;

/**
 * Represents an external data source (e.g., Yahoo Finance API).
 */
public interface PriceDataSource {

    List<SharePrice> fetchPrices(String symbol);
}
