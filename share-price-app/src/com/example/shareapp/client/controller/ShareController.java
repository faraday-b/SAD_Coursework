package com.example.shareapp.client.controller;

import com.example.shareapp.domain.service.IShareService;
import java.time.LocalDate;

public class ShareController implements IRequest {
    private final IShareService shareService;

    public ShareController(IShareService shareService) {
        this.shareService = shareService;
    }

    @Override
    public void handleComparisonRequest(String s1, String s2, LocalDate start, LocalDate end) {
        // Delegates to the Domain layer as per Clean Architecture
        shareService.compareShares(s1, s2, start, end);
    }
}