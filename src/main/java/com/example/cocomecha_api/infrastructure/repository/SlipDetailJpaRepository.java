package com.example.cocomecha_api.infrastructure.repository;

import com.example.cocomecha_api.infrastructure.entity.SlipDetailEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SlipDetailJpaRepository extends JpaRepository<SlipDetailEntity, String> {

  Optional<SlipDetailEntity> findById(String slipNo);
  
  void deleteById(String slipNo);
}
