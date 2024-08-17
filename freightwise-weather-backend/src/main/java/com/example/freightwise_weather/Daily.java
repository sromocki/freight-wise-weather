package com.example.freightwise_weather;

import java.util.List;

public final class Daily {
    private final long dt;
    private final long sunrise;
    private final long sunset;
    private final Temp temp;
    private final FeelsLike feelsLike;
    private final int pressure;
    private final int humidity;
    private final double dewPoint;
    private final double windSpeed;
    private final int windDeg;
    private final List<Weather> weather;
    private final int clouds;
    private final double pop;
    private final double uvi;

    public Daily(long dt, long sunrise, long sunset, Temp temp, FeelsLike feelsLike, int pressure, int humidity, double dewPoint, double windSpeed, int windDeg, List<Weather> weather, int clouds, double pop, double uvi) {
        this.dt = dt;
        this.sunrise = sunrise;
        this.sunset = sunset;
        this.temp = temp;
        this.feelsLike = feelsLike;
        this.pressure = pressure;
        this.humidity = humidity;
        this.dewPoint = dewPoint;
        this.windSpeed = windSpeed;
        this.windDeg = windDeg;
        this.weather = weather;
        this.clouds = clouds;
        this.pop = pop;
        this.uvi = uvi;
    }

    public long getDt() {
        return dt;
    }

    public long getSunrise() {
        return sunrise;
    }

    public long getSunset() {
        return sunset;
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

    public static final class Temp {
        private final double day;
        private final double min;
        private final double max;
        private final double night;
        private final double eve;
        private final double morn;

        public Temp(double day, double min, double max, double night, double eve, double morn) {
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

        public FeelsLike(double day, double night, double eve, double morn) {
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