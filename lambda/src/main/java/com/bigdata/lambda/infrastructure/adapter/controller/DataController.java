package com.bigdata.lambda.infrastructure.adapter.controller;

import com.bigdata.lambda.application.service.DataService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/sensor")
public class DataController {

    private final DataService dataService;

    public DataController(DataService dataService) {
        this.dataService = dataService;
    }

    @PostMapping("/ingest")
    public ResponseEntity<String> ingestData(@RequestBody Map<String, Object> request) {
        String sensorId = (String) request.get("sensorId");
        double value = ((Number) request.get("value")).doubleValue();
        dataService.ingestData(sensorId, value);
        return ResponseEntity.ok("Data ingested");
    }

    @GetMapping("/data")
    public ResponseEntity<?> getAllData() {
        return ResponseEntity.ok(dataService.getAllSensorData());
    }
}