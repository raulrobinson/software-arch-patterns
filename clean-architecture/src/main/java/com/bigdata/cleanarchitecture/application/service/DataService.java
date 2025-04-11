package com.bigdata.cleanarchitecture.application.service;

import com.bigdata.cleanarchitecture.domain.model.SensorData;
import com.bigdata.cleanarchitecture.domain.repository.SensorDataRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class DataService {

    private final SensorDataRepository sensorDataRepository;

    public DataService(SensorDataRepository sensorDataRepository) {
        this.sensorDataRepository = sensorDataRepository;
    }

    public void ingestData(String sensorId, double value) {
        SensorData data = new SensorData(null, sensorId, LocalDateTime.now(), value);
        sensorDataRepository.save(data);
    }

    public List<SensorData> getAllSensorData() {
        return sensorDataRepository.findAll();
    }
}
