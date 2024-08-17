package com.example.freightwise_weather;

public class WeatherParsingException extends RuntimeException {
    public WeatherParsingException(String message) {
        super(message);
    }

    public WeatherParsingException(String message, Throwable cause) {
        super(message, cause);
    }
}