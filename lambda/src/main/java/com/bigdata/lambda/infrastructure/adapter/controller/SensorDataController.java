package com.bigdata.lambda.infrastructure.adapter.controller;

import com.bigdata.lambda.application.service.SensorAggregationService;
import com.bigdata.lambda.domain.model.SensorData;
import com.bigdata.lambda.infrastructure.adapter.kafka.KafkaSensorProducer;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("${controller.properties.base-path}/sensor")
public class SensorDataController {

    private final SensorAggregationService service;

    private final KafkaSensorProducer producer;

    public SensorDataController(SensorAggregationService service, KafkaSensorProducer producer) {
        this.service = service;
        this.producer = producer;
    }

    @GetMapping("/all")
    public List<SensorData> getAllData() {
        return service.getAllData();
    }

    @PostMapping("/create-message-broker")
    public ResponseEntity<String> postSensorData(@RequestBody SensorData data) {
        producer.send(data);
        return ResponseEntity.ok("Data sent to Kafka successfully.");
    }
}