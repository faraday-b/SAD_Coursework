package com.example.shareapp.client.ui;
// This defines the contract for rendering data to the user.
import com.example.shareapp.domain.model.SharePrice;
import java.util.List;

public interface IVisualise {
    void renderComparisonChart(String title, List<SharePrice> data);
}