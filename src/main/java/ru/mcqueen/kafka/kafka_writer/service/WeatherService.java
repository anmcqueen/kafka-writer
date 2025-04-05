package ru.mcqueen.kafka.kafka_writer.service;

import ru.mcqueen.kafka.kafka_writer.model.Weather;

public interface WeatherService {
    public void sendMessage(Weather weather);
}
