package com.example.shareapp.infrastructure.datasource;

import com.example.shareapp.domain.model.SharePrice;
import java.time.LocalDate;
import java.util.List;

public interface IPriceDataSource {
    List<SharePrice> fetchPrices(String symbol, LocalDate start, LocalDate end);
}