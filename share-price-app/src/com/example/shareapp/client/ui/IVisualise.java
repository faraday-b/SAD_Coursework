package com.example.shareapp.client.ui;

import com.example.shareapp.domain.model.SharePrice;
import java.util.List;
import java.util.Map;

public interface IVisualise {
    void displayComparison(Map<String, List<SharePrice>> data);
    void displayError(String message);
}