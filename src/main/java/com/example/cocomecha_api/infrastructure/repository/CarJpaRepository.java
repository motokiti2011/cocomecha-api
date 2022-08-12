package com.example.cocomecha_api.infrastructure.repository;

import com.example.cocomecha_api.infrastructure.entity.CarEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CarJpaRepository extends JpaRepository<CarEntity, Integer> {
    List<CarEntity> findByPriceLessThanEqualOrderByPriceAsc(Integer price);
}
