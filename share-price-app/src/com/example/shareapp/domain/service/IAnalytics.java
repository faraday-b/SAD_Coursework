package com.example.shareapp.domain.service;

import com.example.shareapp.domain.model.SharePrice;
import java.util.List;

public interface IAnalytics {
    double calculate(List<SharePrice> prices, AnalysisType type);
}