package com.weather.weatherapi.controller;

import com.weather.weatherapi.dto.WeatherResponse;
import com.weather.weatherapi.service.WeatherService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/weather")
public class WeatherController {

    private final WeatherService weatherService;

    public WeatherController(WeatherService weatherService) {
        this.weatherService = weatherService;
    }

    @GetMapping
    public WeatherResponse getWeather(@RequestParam String city) {
        return weatherService.getWeather(city);
    }
}
