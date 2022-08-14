package com.example.cocomecha_api.domain.model;


import lombok.Builder;
import lombok.Data;

import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

@Data
@Builder
public class UserMyList {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private String id;
  private String slipNo;
  private String userId;
  private String title;
  private String category;
  private String area;
  private String price;
  private String bidMethod;
  private String bidderId;
  private String bidEndDate;
  private String explanation;
  private String preferredDate;
  private String preferredTime;
  private String completionDate;
  private String deleteDiv;
  private String imageUrl;
}
