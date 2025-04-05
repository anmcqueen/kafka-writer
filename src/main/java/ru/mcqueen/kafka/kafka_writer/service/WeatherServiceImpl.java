package ru.mcqueen.kafka.kafka_writer.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import ru.mcqueen.kafka.kafka_writer.model.Weather;


@Slf4j
@Service
//@RequiredArgsConstructor
public class WeatherServiceImpl implements WeatherService{
    private final KafkaTemplate<String, Object> kafkaTemplate;

    @Value("${app.kafka.topic.name}")
    private String topicName;

    public WeatherServiceImpl(KafkaTemplate<String, Object> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    @Override
    public void sendMessage(Weather weather) {

        // Получаем ключ из объекта
        String key = weather.getRegion();

//        CompletableFuture<SendResult<String, Object>> future = kafkaTemplate.send(topicName, key, weather);
        kafkaTemplate.send(topicName, key, weather);

//        future.whenComplete((result, ex) -> {
//            if (ex == null) {
//                // Успешная отправка
//                log.info("Успешно отправлены данные о погоде=\"{}\" с ключом=\"{}\" в партицию=\"{}\" с offset=\"{}\" топика=\"{}\"",
//                        weather,
//                        key,
//                        result.getRecordMetadata().partition(),
//                        result.getRecordMetadata().offset(),
//                        topicName);
//            } else {
//                // Ошибка при отправке
//                log.error("Не удалось отправить данные о погоде=\"{}\" с ключом=\"{}\"",
//                        weather, key, ex.getMessage());
//            }
//        });


    }
}
