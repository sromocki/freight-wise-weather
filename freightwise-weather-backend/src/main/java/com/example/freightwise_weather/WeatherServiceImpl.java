package com.example.freightwise_weather;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import jakarta.validation.constraints.NotBlank;

import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

@Service
public class WeatherServiceImpl implements WeatherService {

    private static final Logger logger = LoggerFactory.getLogger(WeatherServiceImpl.class);

    private final RestTemplate restTemplate;
    private final ObjectMapper objectMapper;

    @Value("${openweathermap.api.key}")
    private String apiKey;

    @Value("${openweathermap.api.url}")
    private String baseUrl;

    public WeatherServiceImpl(RestTemplate restTemplate, ObjectMapper objectMapper) {
        this.restTemplate = restTemplate;
        this.objectMapper = objectMapper;
    }

    @Override
    public Coordinates getCoordinates(@NotBlank String location) {
        String geocodingUrl;
        boolean isZipCode = location.matches("\\d{5}(-\\d{4})?");
        if (isZipCode) {
            geocodingUrl = baseUrl + "/geo/1.0/zip?zip=" + location + "&appid=" + apiKey;
        } else {
            geocodingUrl = baseUrl + "/geo/1.0/direct?q=" + location + "&limit=1&appid=" + apiKey;
        }
        String response;

        try {
            response = restTemplate.getForObject(geocodingUrl, String.class);
        } catch (RestClientException e) {
            logger.error("Error fetching coordinates for location: {}", location, e);
            throw new CoordinatesNotFoundException("Coordinates not found for location: " + location, e);
        }

        try {
            JsonNode root = objectMapper.readTree(response);
            JsonNode firstResult;
            if (isZipCode) {
                firstResult = root;
            } else {
                firstResult = root.get(0);
            }
            double lat = firstResult.get("lat").asDouble();
            double lon = firstResult.get("lon").asDouble();
            String name = firstResult.get("name").asText();
            String country = firstResult.get("country").asText();
            String state = firstResult.has("state") ? firstResult.get("state").asText() : null;
            String zip = firstResult.has("zip") ? firstResult.get("zip").asText() : null;

            Map<String, String> localNames = new HashMap<>();
            if (firstResult.has("local_names")) {
                JsonNode localNamesNode = firstResult.get("local_names");
                Iterator<Map.Entry<String, JsonNode>> fields = localNamesNode.fields();
                while (fields.hasNext()) {
                    Map.Entry<String, JsonNode> field = fields.next();
                    localNames.put(field.getKey(), field.getValue().asText());
                }
            }

            return new Coordinates(lat, lon, name, localNames, country, state, zip);
        } catch (Exception e) {
            logger.error("Error parsing coordinates response for location: {}", location, e);
            throw new CoordinatesParsingException("Error parsing coordinates response for location: " + location, e);
        }
    }

    @Override
    public CurrentWeather getCurrentWeather(@NotBlank String location) {
        Coordinates coordinates = getCoordinates(location);
        if (coordinates == null) {
            throw new CoordinatesNotFoundException("Coordinates not found for location: " + location);
        }

        String weatherUrl = baseUrl + "/data/3.0/onecall?lat=" + coordinates.getLat() + "&lon=" + coordinates.getLon() + "&exclude=minutely&appid=" + apiKey + "&units=imperial";
        String response;
        try {
            response = restTemplate.getForObject(weatherUrl, String.class);
        } catch (RestClientException e) {
            logger.error("Error fetching weather for coordinates: {}", coordinates, e);
            throw new WeatherNotFoundException("Weather not found for coordinates: " + coordinates, e);
        }

        try {
            CurrentWeather currentWeather = objectMapper.readValue(response, CurrentWeather.class);
            currentWeather.setName(coordinates.getName());
            return currentWeather;
        } catch (Exception e) {
            logger.error("Error parsing weather response for coordinates: {}", coordinates, e);
            throw new WeatherParsingException("Error parsing weather response for coordinates: " + coordinates, e);
        }
    }
}