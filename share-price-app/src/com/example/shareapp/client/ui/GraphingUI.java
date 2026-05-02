package com.example.shareapp.client.ui;

import com.example.shareapp.domain.model.SharePrice;
import java.util.List;

/**
 * Specifically manages the display of share performance graphs.
 */
public class GraphingUI implements IVisualise {
    private final IStyle styleManager;

    public GraphingUI() {
        this.styleManager = new StyleManager();
    }

    @Override
    public void renderComparisonChart(String title, List<SharePrice> data) {
        String color = styleManager.getChartColor();
        
        System.out.println("--- Rendering Chart: " + title + " ---");
        System.out.println("Applying Style Color: " + color);
        
        if (data == null || data.isEmpty()) {
            // Simulated empty state for the chart
            System.out.println("[UI] Displaying empty comparison axes...");
        } else {
            // Logic to iterate through data and plot points would go here
            System.out.println("[UI] Plotting " + data.size() + " price points.");
        }
        System.out.println("------------------------------------------");
    }
}