package com.example.freightwise_weather;

interface WeatherService {

    public Coordinates getCoordinates(String location);
    public CurrentWeather getCurrentWeather(String location);
}