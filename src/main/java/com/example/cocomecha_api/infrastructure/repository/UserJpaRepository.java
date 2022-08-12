package com.example.cocomecha_api.infrastructure.repository;

import com.example.cocomecha_api.infrastructure.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserJpaRepository extends JpaRepository<UserEntity, Integer> {
    List<UserEntity> findByUserid(Integer userid);
}
