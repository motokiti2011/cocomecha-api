package com.example.cocomecha_api.domain.model;
  

import java.io.Serializable;
import java.util.List;

import javax.persistence.Id;

import lombok.Data;
import lombok.Builder;

@Data
@Builder
public class User implements Serializable{
	
	@Id
	private String mailaddress;
	private String encodedPassword;
	private String name;
	private List<Role> roles;
	
}