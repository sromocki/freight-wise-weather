package com.example.freightwise_weather;

import java.util.Map;

public final class Coordinates {
    private final double lat;
    private final double lon;
    private final String name;
    private final Map<String, String> localNames;
    private final String country;
    private final String state;

    private final String zip;

    public Coordinates(double lat, double lon, String name, Map<String, String> localNames, String country, String state, String zip) {
        this.lat = lat;
        this.lon = lon;
        this.name = name;
        this.localNames = localNames;
        this.country = country;
        this.state = state;
        this.zip = zip;
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

    public Map<String, String> getLocalNames() {
        return localNames;
    }

    public String getCountry() {
        return country;
    }

    public String getState() {
        return state;
    }

    public String getZip() {
        return zip;
    }
}