package com.bigdata.lambda.application.service;

import com.bigdata.lambda.domain.model.SensorData;
import com.bigdata.lambda.domain.port.SensorDataRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SensorAggregationService {

    private final SensorDataRepository repository;

    public SensorAggregationService(SensorDataRepository repository) {
        this.repository = repository;
    }

    public void saveSensorData(SensorData data) {
        repository.save(data);
    }

    public List<SensorData> getAllData() {
        return repository.findAll();
    }
}
