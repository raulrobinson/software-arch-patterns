package com.bigdata.lambda.domain.repository;

import com.bigdata.lambda.domain.model.SensorData;

import java.util.List;

public interface SensorDataRepository {
    void save(SensorData sensorData);
    List<SensorData> findAll();
}
