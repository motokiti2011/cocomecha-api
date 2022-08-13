package com.example.cocomecha_api.domain.model;

import lombok.Builder;
import lombok.Data;

import javax.persistence.Id;


@Data
@Builder
public class SignUpUser {
    @Id
    private Integer user_id;
    private String loginid;
    private String password;
    private String user_name;
    private String mail_adress;
    private String area;
    private String corporation_div;
    private String office_name;
    private String introduction;
}
