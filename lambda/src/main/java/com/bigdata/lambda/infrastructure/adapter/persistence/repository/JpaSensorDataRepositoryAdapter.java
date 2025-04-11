package com.bigdata.lambda.infrastructure.adapter.persistence.repository;

import com.bigdata.lambda.domain.model.SensorData;
import com.bigdata.lambda.domain.port.SensorDataRepository;
import com.bigdata.lambda.infrastructure.adapter.persistence.entity.SensorDataEntity;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class JpaSensorDataRepositoryAdapter implements SensorDataRepository {

    private final JpaSensorDataRepository jpaRepository;

    public JpaSensorDataRepositoryAdapter(JpaSensorDataRepository jpaRepository) {
        this.jpaRepository = jpaRepository;
    }

    @Override
    public void save(SensorData sensorData) {
        SensorDataEntity entity = new SensorDataEntity(
                sensorData.getSensorId(),
                sensorData.getTimestamp(),
                sensorData.getValue()
        );
        jpaRepository.save(entity);
    }

    @Override
    public List<SensorData> findAll() {
        return jpaRepository.findAll().stream().map(e ->
                new SensorData(e.getId(), e.getSensorId(), e.getTimestamp().toString(), e.getSensorValue())
        ).collect(Collectors.toList());
    }
}
