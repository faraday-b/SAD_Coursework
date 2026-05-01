package com.example.shareapp.domain.service;

import java.util.Optional;

/**
 * SOA Wrapper to ensure interoperability and modularity.
 * It encapsulates the result of any service operation.
 * @param <T> The type of the data being returned.
 */
public class ServiceResponse<T> {
    private final T data;
    private final boolean success;
    private final String message;

    private ServiceResponse(T data, boolean success, String message) {
        this.data = data;
        this.success = success;
        this.message = message;
    }

    // Static factory methods for cleaner "Service-Oriented" calls
    public static <T> ServiceResponse<T> ok(T data) {
        return new ServiceResponse<>(data, true, "Success");
    }

    public static <T> ServiceResponse<T> error(String message) {
        return new ServiceResponse<>(null, false, message);
    }

    public boolean isSuccess() { return success; }
    public String getMessage() { return message; }
    public Optional<T> getData() { return Optional.ofNullable(data); }
}