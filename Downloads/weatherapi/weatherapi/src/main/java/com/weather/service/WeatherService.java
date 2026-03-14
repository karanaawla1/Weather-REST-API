package com.weather.weatherapi.service;

import com.weather.weatherapi.dto.WeatherResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import java.util.Map;

@Service
public class WeatherService {

    @Value("${weather.api.key}")
    private String apiKey;

    @Value("${weather.api.url}")
    private String apiUrl;

    private final RestTemplate restTemplate = new RestTemplate();

    public WeatherResponse getWeather(String city) {
        String url = apiUrl + "?q=" + city + "&appid=" + apiKey + "&units=metric";

        Map response = restTemplate.getForObject(url, Map.class);

        Map main = (Map) response.get("main");
        Map weather = (Map) ((java.util.List) response.get("weather")).get(0);

        WeatherResponse result = new WeatherResponse();
        result.setCity(city);
        result.setCountry((String) ((Map) response.get("sys")).get("country"));
        result.setTemperature(((Number) main.get("temp")).doubleValue());
        result.setFeelsLike(((Number) main.get("feels_like")).doubleValue());
        result.setHumidity(((Number) main.get("humidity")).intValue());
        result.setDescription((String) weather.get("description"));
        result.setIcon((String) weather.get("icon"));

        return result;
    }
}