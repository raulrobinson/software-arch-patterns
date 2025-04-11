package com.bigdata.cleanarchitecture.domain.model;

import java.time.LocalDateTime;

public class SensorData {
    private Long id;
    private String sensorId;
    private LocalDateTime timestamp;
    private Double value;

    public SensorData(Long id, String sensorId, LocalDateTime timestamp, Double value) {
        this.id = id;
        this.sensorId = sensorId;
        this.timestamp = timestamp;
        this.value = value;
    }

    public Long getId() { return id; }
    public String getSensorId() { return sensorId; }
    public LocalDateTime getTimestamp() { return timestamp; }
    public Double getValue() { return value; }
}
