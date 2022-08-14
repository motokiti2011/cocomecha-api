package com.example.cocomecha_api.infrastructure.repository;

import com.example.cocomecha_api.infrastructure.entity.UserMyListEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;


public interface UserMyListJpaRepository extends JpaRepository<UserMyListEntity, Integer> {

  Optional<UserMyListEntity> findById(String id);

  void deleteById(String id);
  
}
