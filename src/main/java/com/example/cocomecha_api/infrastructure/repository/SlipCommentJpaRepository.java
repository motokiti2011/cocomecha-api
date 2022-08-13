package com.example.cocomecha_api.infrastructure.repository;

import com.example.cocomecha_api.infrastructure.entity.SlipCommentEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SlipCommentJpaRepository extends JpaRepository<SlipCommentEntity, Integer> {

  Optional<SlipCommentEntity> findById(Integer comment_id);
  
}
