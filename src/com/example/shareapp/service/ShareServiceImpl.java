package com.example.shareapp.service;

import com.example.shareapp.model.SharePrice;
import com.example.shareapp.repository.InMemoryPriceRepository;
import com.example.shareapp.repository.PriceRepository;
import java.util.List;

/**
 * Concrete implementation of ShareService.
 */
public class ShareServiceImpl implements ShareService {

    private PriceRepository repository;

    public ShareServiceImpl() {
        this.repository = new InMemoryPriceRepository();
    }

    @Override
    public List<SharePrice> getSharePrices(String symbol) {

        System.out.println("Service: Fetching prices for " + symbol);

        return repository.findBySymbol(symbol);
    }
}
