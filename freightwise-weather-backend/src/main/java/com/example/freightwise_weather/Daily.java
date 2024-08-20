package com.example.freightwise_weather;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public final class Daily {
    private final long dt;
    private final long sunrise;
    private final long sunset;
    private final long moonrise;
    private final long moonset;
    @JsonProperty("moon_phase")
    private final double moonPhase;
    private final Temp temp;
    @JsonProperty("feels_like")
    private final FeelsLike feelsLike;
    private final int pressure;
    private final int humidity;
    @JsonProperty("dew_point")
    private final double dewPoint;
    @JsonProperty("wind_speed")
    private final double windSpeed;
    @JsonProperty("wind_deg")
    private final int windDeg;
    @JsonProperty("wind_gust")
    private final double windGust;
    private final List<Weather> weather;
    private final int clouds;
    private final double pop;
    private final double uvi;
    private final double rain;
    private final double snow;
    private final String summary;

    public Daily(
            @JsonProperty("dt") long dt,
            @JsonProperty("sunrise") long sunrise,
            @JsonProperty("sunset") long sunset,
            @JsonProperty("moonrise") long moonrise,
            @JsonProperty("moonset") long moonset,
            @JsonProperty("moon_phase") double moonPhase,
            @JsonProperty("temp") Temp temp,
            @JsonProperty("feels_like") FeelsLike feelsLike,
            @JsonProperty("pressure") int pressure,
            @JsonProperty("humidity") int humidity,
            @JsonProperty("dew_point") double dewPoint,
            @JsonProperty("wind_speed") double windSpeed,
            @JsonProperty("wind_deg") int windDeg,
            @JsonProperty("wind_gust") double windGust,
            @JsonProperty("weather") List<Weather> weather,
            @JsonProperty("clouds") int clouds,
            @JsonProperty("pop") double pop,
            @JsonProperty("uvi") double uvi,
            @JsonProperty("rain") double rain,
            @JsonProperty("snow") double snow,
            @JsonProperty("summary") String summary
    ) {
        this.dt = dt;
        this.sunrise = sunrise;
        this.sunset = sunset;
        this.moonrise = moonrise;
        this.moonset = moonset;
        this.moonPhase = moonPhase;
        this.temp = temp;
        this.feelsLike = feelsLike;
        this.pressure = pressure;
        this.humidity = humidity;
        this.dewPoint = dewPoint;
        this.windSpeed = windSpeed;
        this.windDeg = windDeg;
        this.windGust = windGust;
        this.weather = weather;
        this.clouds = clouds;
        this.pop = pop;
        this.uvi = uvi;
        this.rain = rain;
        this.snow = snow;
        this.summary = summary;
    }

    // Getters
    public long getDt() {
        return dt;
    }

    public long getSunrise() {
        return sunrise;
    }

    public long getSunset() {
        return sunset;
    }

    public long getMoonrise() {
        return moonrise;
    }

    public long getMoonset() {
        return moonset;
    }

    public double getMoonPhase() {
        return moonPhase;
    }

    public Temp getTemp() {
        return temp;
    }

    public FeelsLike getFeelsLike() {
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

    public double getWindSpeed() {
        return windSpeed;
    }

    public int getWindDeg() {
        return windDeg;
    }

    public double getWindGust() {
        return windGust;
    }

    public List<Weather> getWeather() {
        return weather;
    }

    public int getClouds() {
        return clouds;
    }

    public double getPop() {
        return pop;
    }

    public double getUvi() {
        return uvi;
    }

    public double getRain() {
        return rain;
    }

    public double getSnow() {
        return snow;
    }

    public String getSummary() {
        return summary;
    }

    public static final class Temp {
        private final double day;
        private final double min;
        private final double max;
        private final double night;
        private final double eve;
        private final double morn;

        public Temp(
                @JsonProperty("day") double day,
                @JsonProperty("min") double min,
                @JsonProperty("max") double max,
                @JsonProperty("night") double night,
                @JsonProperty("eve") double eve,
                @JsonProperty("morn") double morn
        ) {
            this.day = day;
            this.min = min;
            this.max = max;
            this.night = night;
            this.eve = eve;
            this.morn = morn;
        }

        public double getDay() {
            return day;
        }

        public double getMin() {
            return min;
        }

        public double getMax() {
            return max;
        }

        public double getNight() {
            return night;
        }

        public double getEve() {
            return eve;
        }

        public double getMorn() {
            return morn;
        }
    }

    public static final class FeelsLike {
        private final double day;
        private final double night;
        private final double eve;
        private final double morn;

        public FeelsLike(
                @JsonProperty("day") double day,
                @JsonProperty("night") double night,
                @JsonProperty("eve") double eve,
                @JsonProperty("morn") double morn
        ) {
            this.day = day;
            this.night = night;
            this.eve = eve;
            this.morn = morn;
        }

        public double getDay() {
            return day;
        }

        public double getNight() {
            return night;
        }

        public double getEve() {
            return eve;
        }

        public double getMorn() {
            return morn;
        }
    }
}