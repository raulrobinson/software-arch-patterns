package com.bigdata.cleanarchitecture.application.dto;

import io.swagger.v3.oas.annotations.media.Schema;

public class SensorDataDTO {
    @Schema(description = "Sensor ID", example = "sensor123")
    private String sensorId;

    @Schema(description = "Sensor value", example = "23.5")
    private Double value;

    public SensorDataDTO() {
    }

    public SensorDataDTO(String sensorId, Double value) {
        this.sensorId = sensorId;
        this.value = value;
    }

    public String getSensorId() {
        return sensorId;
    }

    public void setSensorId(String sensorId) {
        this.sensorId = sensorId;
    }

    public Double getValue() {
        return value;
    }

    public void setValue(Double value) {
        this.value = value;
    }
}
