package com.bigdata.lambda.infrastructure.adapter.persistence.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "sensor_data")
public class SensorDataEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String sensorId;
    private String timestamp;
    private Double sensorValue;

    public SensorDataEntity() {}

    public SensorDataEntity(String sensorId, String timestamp, Double sensorValue) {
        this.sensorId = sensorId;
        this.timestamp = timestamp;
        this.sensorValue = sensorValue;
    }
}
