package com.example.shareapp.client.ui;
//This defines how domain-independent styles are applied to UI elements.
public interface IStyle {
    void applyTheme(String themeName);
    String getChartColor();
}