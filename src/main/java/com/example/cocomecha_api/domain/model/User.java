package com.example.cocomecha_api.domain.model;

import lombok.Builder;
import lombok.Data;

import javax.persistence.Id;


@Data
@Builder
public class User {
    @Id
    private Integer userid;
    private String username;
    private Integer price;
}
