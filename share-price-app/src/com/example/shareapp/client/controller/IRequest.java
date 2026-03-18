package com.example.shareapp.client.controller;

import java.time.LocalDate;

/**
 * Interface defined in the Component Diagram to handle user requests.
 */
public interface IRequest {
    void handleComparisonRequest(String symbol1, String symbol2, LocalDate start, LocalDate end);
}