package com.example.shareapp.domain.service;

import java.time.LocalDate;

public interface IShareService {
    // Returns a ServiceResponse containing the ComparisonResult compound object
    ServiceResponse<ComparisonResult> compareShares(String symbol1, String symbol2, LocalDate start, LocalDate end);
}