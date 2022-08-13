package com.example.cocomecha_api.domain.model;

import lombok.Builder;
import lombok.Data;

import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;


@Data
@Builder
public class UserDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer user_id;
    private String user_name;
    private String mail_adress;
    private String area;
    private String corporation_div;
    private String office_name;
    private String introduction;
}
