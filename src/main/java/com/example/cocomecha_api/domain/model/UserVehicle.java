package com.example.cocomecha_api.domain.model;

import lombok.Builder;
import lombok.Data;

import javax.persistence.Id;


@Data
@Builder
public class UserVehicle {
  @Id
  private Integer userId;
  private String vehicleName;
  private String vehicleNo;
  private String chassisNo;
  private String designatedClassification;
  private String coler;
  private String colerNo;
  private String firstRegistrationDate;
  private String inspectionExpirationDate;
}
