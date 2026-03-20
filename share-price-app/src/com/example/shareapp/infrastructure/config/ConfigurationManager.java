package com.example.shareapp.infrastructure.config;

public class ConfigurationManager implements IConfig {

    @Override
    public String getApiKey() {
        return "DEFAULT_API_KEY";
    }

    @Override
    public String getDatabasePath() {
        // Requirement: SQLite database path 
        return "jdbc:sqlite:share_data.db";
    }
}