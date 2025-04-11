package com.bigdata.lambda;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("${controller.properties.base-path}/lambda-data")
@RequiredArgsConstructor
public class DataController {

    private final DataService dataService;

    @PostMapping
    public void ingest(@RequestBody SensorData data) {
        dataService.ingestData(data);
    }

    @GetMapping
    public List<SensorData> getAll() {
        return dataService.getAllData();
    }
}
