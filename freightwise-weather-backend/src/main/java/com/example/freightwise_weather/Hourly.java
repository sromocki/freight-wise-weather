package com.example.freightwise_weather;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public final class Hourly {
    private final long dt;
    private final double temp;
    @JsonProperty("feels_like")
    private final double feelsLike;
    private final int pressure;
    private final int humidity;
    @JsonProperty("dew_point")
    private final double dewPoint;
    private final double uvi;
    private final int clouds;
    private final int visibility;
    @JsonProperty("wind_speed")
    private final double windSpeed;
    @JsonProperty("wind_deg")
    private final int windDeg;

    @JsonProperty("wind_gust")
    private final int windGust;

    private final double pop;
    private final Rain rain;
    private final Snow snow;
    private final List<Weather> weather;

    public Hourly(
            @JsonProperty("dt") long dt,
            @JsonProperty("temp") double temp,
            @JsonProperty("feels_like") double feelsLike,
            @JsonProperty("pressure") int pressure,
            @JsonProperty("humidity") int humidity,
            @JsonProperty("dew_point") double dewPoint,
            @JsonProperty("uvi") double uvi,
            @JsonProperty("clouds") int clouds,
            @JsonProperty("visibility") int visibility,
            @JsonProperty("wind_speed") double windSpeed,
            @JsonProperty("wind_deg") int windDeg,
            @JsonProperty("wind_gust") int windGust,
            @JsonProperty("pop") double pop,
            @JsonProperty("rain") Rain rain,
            @JsonProperty("snow") Snow snow,
            @JsonProperty("weather") List<Weather> weather
    ) {
        this.dt = dt;
        this.temp = temp;
        this.feelsLike = feelsLike;
        this.pressure = pressure;
        this.humidity = humidity;
        this.dewPoint = dewPoint;
        this.uvi = uvi;
        this.clouds = clouds;
        this.visibility = visibility;
        this.windSpeed = windSpeed;
        this.windDeg = windDeg;
        this.windGust = windGust;
        this.pop = pop;
        this.rain = rain;
        this.snow = snow;
        this.weather = weather;
    }

    // Getters
    public long getDt() {
        return dt;
    }

    public double getTemp() {
        return temp;
    }

    public double getFeelsLike() {
        return feelsLike;
    }

    public int getPressure() {
        return pressure;
    }

    public int getHumidity() {
        return humidity;
    }

    public double getDewPoint() {
        return dewPoint;
    }

    public double getUvi() {
        return uvi;
    }

    public int getClouds() {
        return clouds;
    }

    public int getVisibility() {
        return visibility;
    }

    public double getWindSpeed() {
        return windSpeed;
    }

    public int getWindDeg() {
        return windDeg;
    }

    public int getWindGust() {
        return windGust;
    }

    public double getPop() {
        return pop;
    }

    public Rain getRain() {
        return rain;
    }

    public Snow getSnow() {
        return snow;
    }

    public List<Weather> getWeather() {
        return weather;
    }
}