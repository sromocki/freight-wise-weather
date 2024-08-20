package com.example.freightwise_weather;

import com.fasterxml.jackson.annotation.JsonProperty;

public final class Rain {
    @JsonProperty("1h")
    private final double oneHour;

    public Rain(@JsonProperty("1h") double oneHour) {
        this.oneHour = oneHour;
    }

    public double getOneHour() {
        return oneHour;
    }
}