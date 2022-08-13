package com.example.cocomecha_api.domain.model;

import lombok.Builder;
import lombok.Data;

import javax.persistence.Id;


@Data
@Builder
public class UserFavorite {
  @Id
  private Integer id;
  private String userId;
  private String slipNo;
  private String title;
  private String imageUrl;
}
