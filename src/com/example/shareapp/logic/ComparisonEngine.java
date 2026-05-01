package com.example.shareapp.logic;



import com.example.shareapp.service.ShareService;

import com.example.shareapp.data.LoggingService;



public class ComparisonEngine {

    private ShareService shareService;

    private AnalyticsService analytics;

    private LoggingService logger = new LoggingService();



    public ComparisonEngine(ShareService shareService, AnalyticsService analytics) {

        this.shareService = shareService;

        this.analytics = analytics;

    }



    public void compareStocks(String s1, String s2) {

        logger.logAction("Synchronizing datasets for " + s1 + " and " + s2);

        shareService.getSharePrices(s1);

        shareService.getSharePrices(s2);

        analytics.calculateVolatility(null); // Example analytics trigger

    }

}
