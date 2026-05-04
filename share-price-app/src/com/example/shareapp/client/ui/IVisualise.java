package com.example.shareapp.client.ui;

import com.example.shareapp.domain.model.SharePrice;
import java.util.List;

public interface IVisualise {
    // This allows the Service to send a summary text to the UI
    void displayComparison(String text);

    // This allows the Service to send the full result for graphing
    void renderComparisonChart(String title, List<SharePrice> data);
}