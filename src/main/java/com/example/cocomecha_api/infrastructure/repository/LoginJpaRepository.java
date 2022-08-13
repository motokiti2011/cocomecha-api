package com.example.cocomecha_api.infrastructure.repository;


import com.example.cocomecha_api.infrastructure.entity.LoginEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface LoginJpaRepository extends JpaRepository<LoginEntity, Integer> {

  Optional<LoginEntity> findById(Integer comment_id);

  Optional<LoginEntity> findByLoginid(String loginid);

  Optional<LoginEntity> findFirstByUserid(Integer userid);

  // LoginEntity save(Login login);
  
}

