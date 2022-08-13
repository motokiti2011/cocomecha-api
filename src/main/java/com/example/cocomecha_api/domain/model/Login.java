package com.example.cocomecha_api.domain.model;

import lombok.Builder;
import lombok.Data;

import javax.persistence.Id;


@Data
@Builder
public class Login {
    @Id
    private String loginid;
    private String password;
    private String userid;
    private String mailaddress;
    private String name;
    private boolean admin;

}


