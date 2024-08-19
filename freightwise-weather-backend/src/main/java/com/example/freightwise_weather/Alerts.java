package com.example.freightwise_weather;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public final class Alerts {
    @JsonProperty("sender_name")
    private final String senderName;
    private final String event;
    private final long start;
    private final long end;
    private final String description;
    private final List<String> tags;

    public Alerts(String senderName, String event, long start, long end, String description, List<String> tags) {
        this.senderName = senderName;
        this.event = event;
        this.start = start;
        this.end = end;
        this.description = description;
        this.tags = tags;
    }

    public String getSenderName() {
        return senderName;
    }

    public String getEvent() {
        return event;
    }

    public long getStart() {
        return start;
    }

    public long getEnd() {
        return end;
    }

    public String getDescription() {
        return description;
    }

    public List<String> getTags() {
        return tags;
    }
}