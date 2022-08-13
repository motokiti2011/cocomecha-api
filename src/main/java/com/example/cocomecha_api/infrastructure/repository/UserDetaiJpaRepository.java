package com.example.cocomecha_api.infrastructure.repository;

import com.example.cocomecha_api.infrastructure.entity.UserDetailEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

/**
 * JPAを利用するためのインタフェース
 */
public interface UserDetaiJpaRepository extends JpaRepository<UserDetailEntity, Integer> {
    
    /**
     * jpaが用意している標準実装がDIにより注入されるので不要  
     * 作成者が忘れっぽいんで記載してます。
     * でも途中でめんどくさくなってます。
    */
    Optional<UserDetailEntity> findById(Integer user_id);

    void deleteById(Integer user_id);
}
