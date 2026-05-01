package com.example.shareapp.domain.service;

import com.example.shareapp.domain.model.ComparisonResult;
import com.example.shareapp.domain.model.SharePrice;
import java.util.List;

public interface IComparison {
    // Ensure this matches the method name in your implementation
    ComparisonResult compare(List<SharePrice> listA, List<SharePrice> listB);
}