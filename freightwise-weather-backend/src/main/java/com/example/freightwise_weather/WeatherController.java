package com.example.freightwise_weather;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
public class WeatherController {

    @Autowired
    private WeatherService weatherService;

    private static final List<String> US_STATES = Arrays.asList(
            "AL", "AK", "AZ", "AR", "CA", "CO", "CT", "DE", "FL", "GA", "HI", "ID", "IL", "IN", "IA", "KS", "KY", "LA", "ME", "MD", "MA", "MI", "MN", "MS", "MO", "MT", "NE", "NV", "NH", "NJ", "NM", "NY", "NC", "ND", "OH", "OK", "OR", "PA", "RI", "SC", "SD", "TN", "TX", "UT", "VT", "VA", "WA", "WV", "WI", "WY",
            "Alabama", "Alaska", "Arizona", "Arkansas", "California", "Colorado", "Connecticut", "Delaware", "Florida", "Georgia", "Hawaii", "Idaho", "Illinois", "Indiana", "Iowa", "Kansas", "Kentucky", "Louisiana", "Maine", "Maryland", "Massachusetts", "Michigan", "Minnesota", "Mississippi", "Missouri", "Montana", "Nebraska", "Nevada", "New Hampshire", "New Jersey", "New Mexico", "New York", "North Carolina", "North Dakota", "Ohio", "Oklahoma", "Oregon", "Pennsylvania", "Rhode Island", "South Carolina", "South Dakota", "Tennessee", "Texas", "Utah", "Vermont", "Virginia", "Washington", "West Virginia", "Wisconsin", "Wyoming"
    );
    @GetMapping("/") public String health() {
        return "Hello and Welcome to FreightWise Weather!!!";
    }

    @GetMapping("/current-weather")
    public ResponseEntity<CurrentWeather> getCurrentWeather(@RequestParam String location) {
        if (location.trim().isEmpty()) {
            return ResponseEntity.badRequest().body(null);
        }

        // Check if the location contains a US state code
        String[] locationParts = location.split(",");
        String statePart = locationParts[locationParts.length - 1].trim();
        boolean containsState = US_STATES.stream().anyMatch(state -> state.equalsIgnoreCase(statePart));

        if (containsState && !location.matches(".*\\bUS\\b.*")) {
            location += ",US";
        }

        CurrentWeather currentWeather = weatherService.getCurrentWeather(location);
        if (currentWeather == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(currentWeather);
    }
}
