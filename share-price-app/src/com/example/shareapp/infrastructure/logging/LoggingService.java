package com.example.shareapp.infrastructure.logging;

import java.time.LocalDateTime;

public class LoggingService implements ILogging {
    @Override
    public void log(String message) {
        // Simple console logging for Sprint 2
        System.out.println("[LOG] " + LocalDateTime.now() + ": " + message);
    }
}