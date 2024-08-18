package com.example.freightwise_weather;

import java.util.List;

public final class CurrentWeather {
    private final double lat;
    private final double lon;
    private String name;
    private final String timezone;
    private final long timezoneOffset;
    private final Current current;
    private final List<Minutely> minutely;
    private final List<Hourly> hourly;
    private final List<Daily> daily;
    private final List<Alerts> alerts;

    public CurrentWeather(double lat, double lon, String name, String timezone, long timezoneOffset, Current current, List<Minutely> minutely, List<Hourly> hourly, List<Daily> daily, List<Alerts> alerts) {
        this.lat = lat;
        this.lon = lon;
        this.name = name;
        this.timezone = timezone;
        this.timezoneOffset = timezoneOffset;
        this.current = current;
        this.minutely = minutely;
        this.hourly = hourly;
        this.daily = daily;
        this.alerts = alerts;
    }

    public double getLat() {
        return lat;
    }

    public double getLon() {
        return lon;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTimezone() {
        return timezone;
    }

    public long getTimezoneOffset() {
        return timezoneOffset;
    }

    public Current getCurrent() {
        return current;
    }

    public List<Minutely> getMinutely() {
        return minutely;
    }

    public List<Hourly> getHourly() {
        return hourly;
    }

    public List<Daily> getDaily() {
        return daily;
    }

    public List<Alerts> getAlerts() {
        return alerts;
    }

    public static final class Current {
        private final long dt;
        private final long sunrise;
        private final long sunset;
        private final double temp;
        private final double feelsLike;
        private final int pressure;
        private final int humidity;
        private final double dewPoint;
        private final double uvi;
        private final int clouds;
        private final int visibility;
        private final double windSpeed;
        private final int windDeg;
        private final List<Weather> weather;

        public Current(long dt, long sunrise, long sunset, double temp, double feelsLike, int pressure, int humidity, double dewPoint, double uvi, int clouds, int visibility, double windSpeed, int windDeg, List<Weather> weather) {
            this.dt = dt;
            this.sunrise = sunrise;
            this.sunset = sunset;
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
            this.weather = weather;
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

        public List<Weather> getWeather() {
            return weather;
        }
    }
}