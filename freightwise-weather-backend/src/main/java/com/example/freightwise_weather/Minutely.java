package com.example.freightwise_weather;

public final class Minutely {
    private final long dt;
    private final double precipitation;

    public Minutely(long dt, double precipitation) {
        this.dt = dt;
        this.precipitation = precipitation;
    }

    public long getDt() {
        return dt;
    }

    public double getPrecipitation() {
        return precipitation;
    }
}