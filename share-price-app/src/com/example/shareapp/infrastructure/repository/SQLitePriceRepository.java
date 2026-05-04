package com.example.shareapp.infrastructure.repository;

import com.example.shareapp.domain.model.SharePrice;
import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class SQLitePriceRepository implements IPriceRepository {
    // The connection string - this creates 'shareapp.db' in your project folder
    private static final String DB_URL = "jdbc:sqlite:shareapp.db";

    public SQLitePriceRepository() {
        // Automatically create the table if it doesn't exist yet
        try (Connection conn = DriverManager.getConnection(DB_URL);
             Statement stmt = conn.createStatement()) {
            String sql = "CREATE TABLE IF NOT EXISTS prices (" +
                    "symbol TEXT, " +
                    "date TEXT, " +
                    "closePrice REAL, " +
                    "PRIMARY KEY (symbol, date))";
            stmt.execute(sql);
        } catch (SQLException e) {
            System.err.println("[DB Error] Table creation failed: " + e.getMessage());
        }
    }

    @Override
    public void savePrices(String symbol, List<SharePrice> prices) {
        String sql = "INSERT OR REPLACE INTO prices (symbol, date, closePrice) VALUES (?, ?, ?)";

        try (Connection conn = DriverManager.getConnection(DB_URL)) {
            conn.setAutoCommit(false);
            try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
                for (SharePrice p : prices) {
                    pstmt.setString(1, symbol);
                    pstmt.setString(2, p.getDate().toString());
                    // FIX: Changed from p.getClosePrice() to p.getPrice()
                    pstmt.setDouble(3, p.getPrice());
                    pstmt.addBatch();
                }
                pstmt.executeBatch();
                conn.commit();
            }
        } catch (SQLException e) {
            System.err.println("[DB Error] Save failed: " + e.getMessage());
        }
    }

    @Override
    public List<SharePrice> getPrices(String symbol, LocalDate start, LocalDate end) {
        List<SharePrice> results = new ArrayList<>();
        String sql = "SELECT date, closePrice FROM prices WHERE symbol = ? AND date BETWEEN ? AND ?";

        try (Connection conn = DriverManager.getConnection(DB_URL);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, symbol);
            pstmt.setString(2, start.toString());
            pstmt.setString(3, end.toString());

            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                LocalDate date = LocalDate.parse(rs.getString("date"));
                double price = rs.getDouble("closePrice");
                // FIX: Added 'symbol' to the constructor call
                results.add(new SharePrice(symbol, price, date));
            }
        } catch (SQLException e) {
            System.err.println("[DB Error] Retrieval failed: " + e.getMessage());
        }
        return results;
    }
}