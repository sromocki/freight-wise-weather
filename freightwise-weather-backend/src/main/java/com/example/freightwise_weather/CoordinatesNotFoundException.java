package com.example.freightwise_weather;

public class CoordinatesNotFoundException extends RuntimeException {
    public CoordinatesNotFoundException(String message) {
        super(message);
    }

    public CoordinatesNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}