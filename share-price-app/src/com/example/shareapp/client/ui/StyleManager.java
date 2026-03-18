package com.example.shareapp.client.ui;

public class StyleManager implements IStyle {
    @Override
    public void applyTheme() {
        System.out.println("[STYLE] Applying default system theme.");
    }

    @Override
    public void setGraphColor(String color) {
        System.out.println("[STYLE] Setting graph color to: " + color);
    }
}