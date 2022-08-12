package com.example.cocomecha_api.infrastructure.repository;

import com.example.cocomecha_api.domain.model.Car;
import com.example.cocomecha_api.domain.repository.CarRepository;
import com.example.cocomecha_api.infrastructure.entity.CarEntity;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Collectors;

@Repository
@RequiredArgsConstructor
public class CarRepositoryImpl implements CarRepository {

    @NonNull
    private final CarJpaRepository carJpaRepository;

    @Override
    public List<Car> findByPriceLessThanEqualOrderByPriceAsc(Integer price) {
        return this.carJpaRepository.findByPriceLessThanEqualOrderByPriceAsc(price)
                .stream().map(CarEntity::toDomainCar)
                .collect(Collectors.toList());
    }
}
