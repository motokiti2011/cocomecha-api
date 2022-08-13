package com.example.cocomecha_api.infrastructure.repository;

import com.example.cocomecha_api.infrastructure.entity.RoleEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleJpaRepository extends JpaRepository<RoleEntity, Integer> {
  
}
