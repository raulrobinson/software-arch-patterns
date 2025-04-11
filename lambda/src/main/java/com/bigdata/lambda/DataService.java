package com.bigdata.lambda;

import lombok.RequiredArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DataService {

    private final SensorDataRepository repository;
    private final KafkaTemplate<String, SensorData> kafkaTemplate;

    private static final String TOPIC = "sensor-data";

    /**
     * Ingesta de datos: envía datos a Kafka para procesamiento en tiempo real.
     */
    public void ingestData(SensorData data) {
        kafkaTemplate.send(TOPIC, data);
    }

    /**
     * Persistencia: almacena datos procesados por lotes en base de datos.
     */
    public void saveBatch(SensorData data) {
        repository.save(data);
    }

    /**
     * Consulta de datos históricos.
     */
    public List<SensorData> getAllData() {
        return repository.findAll();
    }
}
