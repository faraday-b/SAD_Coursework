package com.example.shareapp.domain.service;

import com.example.shareapp.domain.model.ComparisonResult;
import java.time.LocalDate;

public interface IShareService {
    // This return type ensures interoperability
    ServiceResponse<ComparisonResult> compareShares(String symbol1, String symbol2, LocalDate start, LocalDate end);
}