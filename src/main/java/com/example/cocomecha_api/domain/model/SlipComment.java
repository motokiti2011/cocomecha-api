package com.example.cocomecha_api.domain.model;

import lombok.Builder;
import lombok.Data;

import javax.persistence.Id;


@Data
@Builder
public class SlipComment {
  @Id
  private Integer commentId;
  private Integer slipNo;
  private String displayOrder;
  private Integer userId;
  private String comment;
}
