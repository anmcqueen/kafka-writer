package ru.mcqueen.kafka.kafka_writer.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.mcqueen.kafka.kafka_writer.model.Weather;
import ru.mcqueen.kafka.kafka_writer.service.WeatherService;

@RestController
@RequestMapping({"/api/v1/weather/"})
public class WeatherController {

    private final WeatherService weatherService;

    public WeatherController(WeatherService weatherService) {
        this.weatherService = weatherService;
    }

    @PostMapping({"/send"})
    public ResponseEntity<HttpStatus> sendMessage(@RequestBody Weather weather) {
        weatherService.sendMessage(weather);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
