package com.example.cocomecha_api.domain.model;

import lombok.Builder;
import lombok.Data;

import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
// import javax.persistence.ManyToOne;


@Data
@Builder
public class SlipDetail {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
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
  private String displayDiv;
  private String preferredDate;
  private String preferredTime;
  private String completionDate;
  private String deleteDiv;
  private String imageUrl;
}
