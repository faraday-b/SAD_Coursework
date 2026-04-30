package com.example.shareapp.infrastructure.datasource;

import com.example.shareapp.domain.model.SharePrice;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ExternalAPIConnector implements IAccess, IPriceDataSource {

    // Get your free key at https://www.alphavantage.co/support/#api-key
    private static final String API_KEY = "0A3125J3Y5IK5NON";

    @Override
    public List<SharePrice> accessExternalData(String symbol, LocalDate start, LocalDate end) {
        return fetchPrices(symbol, start, end);
    }

    @Override
    public List<SharePrice> fetchPrices(String symbol, LocalDate start, LocalDate end) {
        // Enforce the 2-year spec requirement
        if (start.isBefore(end.minusYears(2))) {
            start = end.minusYears(2);
        }

        List<SharePrice> results = new ArrayList<>();

        try {
            // Alpha Vantage Daily Time Series URL
            String url = String.format(
                    "https://www.alphavantage.co/query?function=TIME_SERIES_DAILY&symbol=%s&apikey=%s",
                    symbol, API_KEY
            );

            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(url))
                    .build();

            // This line specifically throws IOException and InterruptedException
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            if (response.statusCode() == 200) {
                String body = response.body();

                // Check for Alpha Vantage rate limit message
                if (body.contains("Note")) {
                    System.err.println("[API Error] Alpha Vantage rate limit reached (25 requests/day).");
                    return results;
                }

                // Regex to find "YYYY-MM-DD": { ... "4. close": "123.4567" }
                // This extracts the date from the key and the closing price from the nested object
                Pattern pattern = Pattern.compile("\"(\\d{4}-\\d{2}-\\d{2})\":\\s*\\{[^}]*?\"4\\. close\":\\s*\"(\\d+\\.?\\d*)\"");
                Matcher matcher = pattern.matcher(body);

                while (matcher.find()) {
                    LocalDate date = LocalDate.parse(matcher.group(1));
                    double closePrice = Double.parseDouble(matcher.group(2));

                    // Filter by requested dates
                    if (!date.isBefore(start) && !date.isAfter(end)) {
                        results.add(new SharePrice(date, closePrice));
                    }
                }

                System.out.println("[API] Successfully fetched " + results.size() + " records for " + symbol);
            } else {
                System.err.println("[API Error] Status Code: " + response.statusCode());
            }

            // ONLY catch the specific errors thrown by the methods above
        } catch (IOException | InterruptedException e) {
            System.err.println("[API Error] Connection problem: " + e.getMessage());
            if (e instanceof InterruptedException) {
                Thread.currentThread().interrupt();
            }
        } catch (RuntimeException e) {
            // Catches parsing errors (like Double.parseDouble) without being "too broad"
            System.err.println("[Data Error] Parsing failed: " + e.getMessage());
        }

        return results;
    }
}