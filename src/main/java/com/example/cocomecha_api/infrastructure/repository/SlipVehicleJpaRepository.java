package com.example.cocomecha_api.infrastructure.repository;

import com.example.cocomecha_api.infrastructure.entity.SlipVehicleEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SlipVehicleJpaRepository extends JpaRepository<SlipVehicleEntity, Integer>  {

  Optional<SlipVehicleEntity> findById(Integer slipNo);

  void deleteById(Integer slipNo);

}
