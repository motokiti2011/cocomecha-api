package com.example.cocomecha_api.infrastructure.repository;

import com.example.cocomecha_api.infrastructure.entity.UserFavoriteEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;


public interface UserFavoriteJpaRepository extends JpaRepository<UserFavoriteEntity, Integer> {
 
    Optional<UserFavoriteEntity> findById(Integer id);

  }
