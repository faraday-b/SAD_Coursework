package com.example.shareapp.domain.service;

import com.example.shareapp.domain.model.SharePrice;
import java.util.List;
import java.util.Map;

public interface IComparison {
    // Calculates the percentage growth or difference between two sets of prices
    Map<String, Double> calculateGrowth(Map<String, List<SharePrice>> data);
}