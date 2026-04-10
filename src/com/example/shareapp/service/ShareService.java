package com.example.shareapp.service;

import com.example.shareapp.model.SharePrice;
import java.util.List;

/**
 * Service layer abstraction.
 * Defines business logic operations.
 */
public interface ShareService {

    List<SharePrice> getSharePrices(String symbol);
}
