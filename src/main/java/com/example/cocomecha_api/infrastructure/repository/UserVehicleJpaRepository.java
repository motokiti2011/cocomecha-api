package com.example.cocomecha_api.infrastructure.repository;

import com.example.cocomecha_api.infrastructure.entity.UserVehicleEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;


public interface UserVehicleJpaRepository extends JpaRepository<UserVehicleEntity, Integer> {
 
    Optional<UserVehicleEntity> findById(Integer user_id);

    void deleteById(Integer user_id);
  }
