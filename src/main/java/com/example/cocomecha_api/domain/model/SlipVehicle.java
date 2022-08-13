package com.example.cocomecha_api.domain.model;

import lombok.Builder;
import lombok.Data;

import javax.persistence.Id;


@Data
@Builder
public class SlipVehicle {
  @Id
  private Integer slip_no;
  private String vehicle_name;
  private String vehicle_no;
  private String chassis_no;
  private String designated_classification;
  private String coler;
  private String coler_no;
  private String inspection_expiration_date;
}
