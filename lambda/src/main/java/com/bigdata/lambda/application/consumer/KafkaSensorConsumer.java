package com.bigdata.lambda.application.consumer;

import com.bigdata.lambda.application.service.SensorAggregationService;
import com.bigdata.lambda.domain.model.SensorData;
import com.google.gson.Gson;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class KafkaSensorConsumer {

    private final SensorAggregationService service;
    private final Gson gson = new Gson();

    public KafkaSensorConsumer(SensorAggregationService service) {
        this.service = service;
    }

    @KafkaListener(topics = "${kafka.topic.name}", groupId = "${spring.kafka.consumer.group-id}")
    public void consume(ConsumerRecord<String, String> record) {
        SensorData data = gson.fromJson(record.value(), SensorData.class);
        data.setTimestamp(LocalDateTime.now().toString());
        service.saveSensorData(data);
    }
}
