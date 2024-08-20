package com.example.freightwise_weather;

import com.fasterxml.jackson.annotation.JsonProperty;

public final class Snow {
    @JsonProperty("1h")
    private final double oneHour;

    public Snow(@JsonProperty("1h") double oneHour) {
        this.oneHour = oneHour;
    }

    public double getOneHour() {
        return oneHour;
    }
}