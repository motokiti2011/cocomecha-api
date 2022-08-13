package com.example.cocomecha_api.infrastructure.repository;
import com.example.cocomecha_api.infrastructure.entity.UserBrowsingHistoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserBrowsingHistoryJpaRepository extends JpaRepository<UserBrowsingHistoryEntity, Integer> {
 
    Optional<UserBrowsingHistoryEntity> findById(Integer id);

  }
