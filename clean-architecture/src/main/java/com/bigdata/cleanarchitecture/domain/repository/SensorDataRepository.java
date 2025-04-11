package com.bigdata.cleanarchitecture.domain.repository;

import com.bigdata.cleanarchitecture.domain.model.SensorData;

import java.util.List;

public interface SensorDataRepository {
    void save(SensorData sensorData);
    List<SensorData> findAll();
}
