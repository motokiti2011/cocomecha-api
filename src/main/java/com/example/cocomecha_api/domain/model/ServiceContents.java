package com.example.cocomecha_api.domain.model;
import lombok.Builder;
import lombok.Data;

import javax.persistence.Id;


@Data
@Builder
public class ServiceContents {
  @Id
  private Integer slip_no;
  private Integer user_id;
  private String title;
  private String category;
  private String area;
  private String price;
  private String bid_method;
  private String bidder_id;
  private String bid_end_date;
  private String explanation;
  private String display_div;
  private String preferred_date;
  private String preferred_time;
  private String completion_date;
  private String delete_div;
}
