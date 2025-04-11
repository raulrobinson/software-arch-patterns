package com.bigdata.lambda;

import lombok.RequiredArgsConstructor;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class KafkaConsumerService {

    private final DataService dataService;

    @KafkaListener(topics = "sensor-data", groupId = "lambda-group")
    public void consume(SensorData data) {
        // Guardar en BD simulando la capa batch
        dataService.saveBatch(data);
    }
}
