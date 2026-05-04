package com.example.shareapp;

import com.example.shareapp.domain.model.ComparisonResult;
import com.example.shareapp.client.controller.ShareController;
import com.example.shareapp.client.ui.GraphingUI;
import com.example.shareapp.domain.service.*;
import com.example.shareapp.domain.validation.ShareValidator;
import com.example.shareapp.infrastructure.repository.SQLitePriceRepository;
import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        System.out.println(">>> STARTING SHARE ANALYSIS SYSTEM <<<");

        try {
            // Setup Parts
            SQLitePriceRepository repository = new SQLitePriceRepository();
            ShareValidator validator = new ShareValidator();
            AnalyticsServiceImpl analytics = new AnalyticsServiceImpl();
            ComparisonEngineImpl comparison = new ComparisonEngineImpl();
            GraphingUI ui = new GraphingUI();

            // Wire Service (Matched to ShareServiceImpl constructor)
            ShareServiceImpl shareService = new ShareServiceImpl(
                    repository, validator, analytics, comparison, ui
            );

            // Wire Controller
            ShareController controller = new ShareController(shareService);

            // 6. Execute Test
            String stock1 = "AAPL";
            String stock2 = "MSFT";
            LocalDate end = LocalDate.now();
            LocalDate start = end.minusDays(30);

            System.out.println("[Main] Triggering request: " + stock1 + " vs " + stock2);
            controller.handleComparisonRequest(stock1, stock2, start, end);

            System.out.println("\n===========================================");
            System.out.println("   ANALYSIS ATTEMPTED - CHECK FOR WINDOWS  ");
            System.out.println("===========================================");

            // This creates a small popup that prevents the program from closing
            javax.swing.JOptionPane.showMessageDialog(null, "Click OK to close the app and windows.");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}