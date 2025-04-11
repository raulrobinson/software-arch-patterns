package com.bigdata.cleanarchitecture.infrastructure.adapter.controller;

import com.bigdata.cleanarchitecture.application.dto.SensorDataDTO;
import com.bigdata.cleanarchitecture.application.service.DataService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("${controller.properties.base-path}/clean-architecture")
@Tag(name = "Data Controller", description = "Controller for managing sensor data")
public class DataController {

    private final DataService dataService;

    public DataController(DataService dataService) {
        this.dataService = dataService;
    }

    @PostMapping("/ingest")
    @Operation(summary = "Ingest sensor data", description = "Ingests sensor data into the system")
    public ResponseEntity<String> ingestData(@RequestBody SensorDataDTO request) {
        String sensorId = request.getSensorId();
        double value = request.getValue();
        dataService.ingestData(sensorId, value);
        return ResponseEntity.ok("Data ingested");
    }

    @GetMapping("/data")
    @Operation(summary = "Get all sensor data", description = "Retrieves all sensor data from the system")
    public ResponseEntity<?> getAllData() {
        return ResponseEntity.ok(dataService.getAllSensorData());
    }
}