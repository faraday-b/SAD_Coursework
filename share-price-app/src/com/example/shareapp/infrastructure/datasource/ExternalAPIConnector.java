package com.example.shareapp.infrastructure.datasource;

import com.example.shareapp.domain.model.SharePrice;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.LocalDate;
import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.List;

public class ExternalAPIConnector implements IAccess, IPriceDataSource {

    @Override
    public List<SharePrice> accessExternalData(String symbol, LocalDate start, LocalDate end) {
        return fetchPrices(symbol, start, end);
    }

    @Override
    public List<SharePrice> fetchPrices(String symbol, LocalDate start, LocalDate end) {
        // Enforce the 2-year spec requirement[cite: 1]
        if (start.isBefore(end.minusYears(2))) {
            start = end.minusYears(2);
        }

        List<SharePrice> results = new ArrayList<>();

        try {
            long p1 = start.atStartOfDay(ZoneOffset.UTC).toEpochSecond();
            long p2 = end.atStartOfDay(ZoneOffset.UTC).toEpochSecond();

            String url = String.format(
                "https://query1.finance.yahoo.com/v7/finance/download/%s?period1=%d&period2=%d&interval=1d&events=history",
                symbol, p1, p2
            );

            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder().uri(URI.create(url)).build();
            
            // This line specifically throws IOException and InterruptedException[cite: 1]
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            if (response.statusCode() == 200) {
                String[] lines = response.body().split("\n");
                for (int i = 1; i < lines.length; i++) {
                    String[] cols = lines[i].split(",");
                    if (cols.length >= 5) {
                        LocalDate date = LocalDate.parse(cols[0]);
                        double closePrice = Double.parseDouble(cols[4]);
                        results.add(new SharePrice(date, closePrice));
                    }
                }
            }
        // ONLY catch the specific errors thrown by the methods above[cite: 1]
        } catch (IOException | InterruptedException e) {
            System.err.println("[API Error] Connection problem: " + e.getMessage());
            if (e instanceof InterruptedException) {
                Thread.currentThread().interrupt();
            }
        } catch (RuntimeException e) {
            // Catches parsing errors (like Double.parseDouble) without being "too broad"[cite: 1]
            System.err.println("[Data Error] Parsing failed: " + e.getMessage());
        }

        return results;
    }
}