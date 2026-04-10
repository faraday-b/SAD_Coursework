package com.example.shareapp.data;

import java.util.logging.Logger;
import java.util.logging.Level;

/**
 * Logging Service component.
 * Responsible for system telemetry using standard Java Logging.
 */
public class LoggingService {
    // Standard Java Logger instance for this class
    private static final Logger LOGGER = Logger.getLogger(LoggingService.class.getName());

    /**
     * Logs a specific system action.
     * @param action The description of the event to log.
     */
    public void logAction(String action) {
        // FIX: Replaced System.out.println with a logger to satisfy SonarQube
        LOGGER.log(Level.INFO, "{0}", action);
    }
}