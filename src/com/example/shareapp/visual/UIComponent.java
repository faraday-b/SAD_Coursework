package com.example.shareapp.visual;

import com.example.shareapp.data.LoggingService;
import com.example.shareapp.model.SharePrice;
import java.util.List;

public class UIComponent {
    private LoggingService logger = new LoggingService();

    public void renderComparisonChart(String title, List<SharePrice> data) {
        // FIX: Reference 'data' to ensure the parameter is used
        int pointCount = (data != null) ? data.size() : 0;
        logger.logAction("Rendering " + title + " with " + pointCount + " points.");
    }
}