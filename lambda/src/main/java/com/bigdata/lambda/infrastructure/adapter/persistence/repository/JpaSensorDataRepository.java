package com.bigdata.lambda.infrastructure.adapter.persistence.repository;

import com.bigdata.lambda.infrastructure.adapter.persistence.entity.SensorDataEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JpaSensorDataRepository extends JpaRepository<SensorDataEntity, Long> {
}
