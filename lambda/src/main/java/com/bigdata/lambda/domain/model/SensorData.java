package com.bigdata.lambda.domain.model;

import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SensorData {
    private Long id;
    private String sensorId;
    private String timestamp;
    private Double value;
}
