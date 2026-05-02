package com.example.shareapp.client.ui;
// This fulfills the task of applying domain-independent visual styles 
// to ensure the graphing component is reusable and scalable.
public class StyleManager implements IStyle {
    private String currentColor = "#0000FF"; // Default Blue

    @Override
    public void applyTheme(String themeName) {
        if (themeName.equalsIgnoreCase("dark")) {
            this.currentColor = "#333333";
        } else {
            this.currentColor = "#0000FF";
        }
    }

    @Override
    public String getChartColor() {
        return this.currentColor;
    }
}