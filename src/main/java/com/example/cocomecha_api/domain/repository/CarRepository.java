package com.example.cocomecha_api.domain.repository;

import com.example.cocomecha_api.domain.model.Car;

import java.util.List;

public interface CarRepository {

    List<Car> findByPriceLessThanEqualOrderByPriceAsc(Integer price);

}
