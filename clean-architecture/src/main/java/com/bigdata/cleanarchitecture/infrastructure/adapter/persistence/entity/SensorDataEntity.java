package com.bigdata.cleanarchitecture.infrastructure.adapter.persistence.entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "sensor_data")
public class SensorDataEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String sensorId;
    private LocalDateTime timestamp;
    private Double sensorValue;

    public SensorDataEntity() {}

    public SensorDataEntity(String sensorId, LocalDateTime timestamp, Double sensorValue) {
        this.sensorId = sensorId;
        this.timestamp = timestamp;
        this.sensorValue = sensorValue;
    }

    public Long getId() { return id; }
    public String getSensorId() { return sensorId; }
    public LocalDateTime getTimestamp() { return timestamp; }
    public Double getValue() { return sensorValue; }
}
