package com.example.shareapp;

import com.example.shareapp.controller.ShareController;

/**
 * Entry point of the Share Price Comparison Application.
 * Sprint 1: Demonstrates layered architecture structure.
 */
public class Main {

    public static void main(String[] args) {

        System.out.println("Share Price Comparison Application - Sprint 1");

        ShareController controller = new ShareController();
        controller.compareShares("AAPL", "MSFT");
    }
}

