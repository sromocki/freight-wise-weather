package com.example.freightwise_weather;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
 
@RestController
public class WeatherController {

    @Autowired
    private WeatherService weatherService;
    @GetMapping("/") public String health() {
        return "Hello and Welcome to FreightWise Weather!!!";
    }

    @GetMapping("/current-weather")
    public ResponseEntity<CurrentWeather> getCurrentWeather(@RequestParam String location) {
        CurrentWeather currentWeather = weatherService.getCurrentWeather(location);
        if (currentWeather == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(currentWeather);
    }
}
