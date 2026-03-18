package com.example.shareapp.infrastructure.repository;

import com.example.shareapp.domain.model.SharePrice;
import java.time.LocalDate;
import java.util.List;

public interface IPriceRepository {
    void savePrices(String symbol, List<SharePrice> prices);
    List<SharePrice> getPrices(String symbol, LocalDate start, LocalDate end);
}