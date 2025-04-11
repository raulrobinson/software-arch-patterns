package com.bigdata.cleanarchitecture.infrastructure.adapter.persistence.repository;

import com.bigdata.cleanarchitecture.infrastructure.adapter.persistence.entity.SensorDataEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JpaSensorDataRepository extends JpaRepository<SensorDataEntity, Long> {
}
