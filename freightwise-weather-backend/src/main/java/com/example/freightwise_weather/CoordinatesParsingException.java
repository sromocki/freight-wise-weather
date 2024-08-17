package com.example.freightwise_weather;

public class CoordinatesParsingException extends RuntimeException {
    public CoordinatesParsingException(String message) {
        super(message);
    }

    public CoordinatesParsingException(String message, Throwable cause) {
        super(message, cause);
    }
}