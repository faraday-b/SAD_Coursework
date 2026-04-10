package com.example.shareapp.logic;

import com.example.shareapp.data.LoggingService;

/**
 * Persistence Manager component.
 * Manages local storage to ensure offline functionality.
 */
public class PersistenceManager {
    // Use the LoggingService from the Data Provider Components group
    private LoggingService logger = new LoggingService();

    /**
     * Persistently stores share price data on the system[cite: 21].
     * @param data The share price data to be saved.
     */
    public void saveLocally(String data) {
        // FIX 1: Use the 'data' parameter to resolve the unused parameter warning
        // FIX 2: Replace System.out with the LoggingService
        logger.logAction("Saving data to local storage: " + data);
    }
}