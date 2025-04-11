package com.bigdata.lambda.infrastructure.adapter.kafka;

import com.bigdata.lambda.domain.model.SensorData;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class KafkaSensorProducer {
    private static final Logger logger = LoggerFactory.getLogger(KafkaSensorProducer.class);

    private final KafkaTemplate<String, String> kafkaTemplate;
    private final String topic;
    private final ObjectMapper objectMapper;

    public KafkaSensorProducer(KafkaTemplate<String, String> kafkaTemplate,
                               @Value("${kafka.topic.name}") String topic,
                               ObjectMapper objectMapper) {
        this.kafkaTemplate = kafkaTemplate;
        this.topic = topic;
        this.objectMapper = objectMapper;
    }

    public void send(SensorData data) {
        try {
            String json = objectMapper.writeValueAsString(data);
            kafkaTemplate.send(topic, json);
        } catch (JsonProcessingException e) {
            logger.error(e.getMessage());
        }
    }
}
