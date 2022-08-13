package com.example.cocomecha_api.infrastructure.repository;

import com.example.cocomecha_api.infrastructure.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;


/**
 * JPAを利用するためのインタフェース
 */
public interface UserJpaRepository extends JpaRepository<UserEntity, String> {

  Optional<UserEntity> findById(String mailaddress);

}
