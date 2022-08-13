package com.example.cocomecha_api.application;

import com.example.cocomecha_api.domain.model.Car;
import com.example.cocomecha_api.domain.service.CarService;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@CrossOrigin
@RequestMapping(path = "/v1/cars")
public class CarController {

    @NonNull
    private final CarService carService;

    @GetMapping("/{price}")
    @ResponseStatus(HttpStatus.OK)
    public List<Car> findByPriceLessThanEqualOrderByPriceAsc(@PathVariable("price") Integer price) {
        return this.carService.findByPriceLessThanEqualOrderByPriceAsc(price);
    }

}
