package com.example.cocomecha_api.domain.model;

import lombok.Builder;
import lombok.Data;

import javax.persistence.Id;


@Data
@Builder
public class Car {
    @Id
    private Integer id;
    private String name;
    private Integer price;
}
