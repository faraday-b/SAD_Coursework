package com.example.shareapp.controller;

import com.example.shareapp.service.ShareService;
import com.example.shareapp.service.ShareServiceImpl;

/**
 * Controller layer.
 * Acts as an intermediary between UI and Service layer.
 */
public class ShareController {

    private ShareService shareService;

    public ShareController() {
        this.shareService = new ShareServiceImpl();
    }

    /**
     * Compares two share symbols.
     * Sprint 1: Only demonstrates flow through architecture.
     */
    public void compareShares(String symbol1, String symbol2) {

        System.out.println("Comparing shares: " + symbol1 + " and " + symbol2);

        shareService.getSharePrices(symbol1);
        shareService.getSharePrices(symbol2);
    }
}
