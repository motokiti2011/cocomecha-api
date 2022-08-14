package com.example.cocomecha_api.infrastructure.entity;

import com.example.cocomecha_api.domain.model.SlipDetail;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "slip_detail")
public class SlipDetailEntity {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "slip_no")
  private String slipNo;
  @Column(name = "user_id")
  private String userId;
  private String title;
  private String category;
  private String area;
  private String price;
  @Column(name = "bid_method")
  private String bidMethod;
  @Column(name = "bidder_id")
  private String bidderId;
  @Column(name = "bid_end_date")
  private String bidEndDate;
  private String explanation;
  @Column(name = "display_div")
  private String displayDiv;
  @Column(name = "preferred_date")
  private String preferredDate;
  @Column(name = "preferred_time")
  private String preferredTime;
  @Column(name = "completion_date")
  private String completionDate;
  @Column(name = "delete_div")
  private String deleteDiv;
  @Column(name = "image_url")
  private String imageUrl;
  @Column(name = "message_open_lebel")
  private String messageOpenLebel;


  /**
   * ドメインオブジェクトへ変換
   *
   * @return ドメインオブジェクト
   */
  public SlipDetail toDomainSlipDetail() {
      return SlipDetail.builder()
              .slipNo(this.slipNo)
              .userId(this.userId)
              .title(this.title)
              .category(this.category)
              .area(this.area)
              .price(this.price)
              .bidMethod(this.bidMethod)
              .bidderId(this.bidderId)
              .bidEndDate(this.bidEndDate)
              .explanation(this.explanation)
              .displayDiv(this.displayDiv)
              .preferredDate(this.preferredDate)
              .preferredTime(this.preferredTime)
              .completionDate(this.completionDate)
              .deleteDiv(this.deleteDiv)
              .imageUrl(this.imageUrl)
              .messageOpenLebel(this.messageOpenLebel)
              .build();
  }


  /**
   * ドメインオブジェクトからインスタンスを生成
   *
   * @param slipDetail ドメインオブジェクト
   * @return SlipDetailEntity
   */
  public static SlipDetailEntity build(SlipDetail slipDetail) {
      return SlipDetailEntity.builder()
              .slipNo(slipDetail.getSlipNo())
              .userId(slipDetail.getUserId())
              .title(slipDetail.getTitle())
              .category(slipDetail.getCategory())
              .area(slipDetail.getArea())
              .price(slipDetail.getPrice())
              .bidMethod(slipDetail.getBidMethod())
              .bidderId(slipDetail.getBidderId())
              .bidEndDate(slipDetail.getBidEndDate())
              .explanation(slipDetail.getExplanation())
              .displayDiv(slipDetail.getDisplayDiv())
              .preferredDate(slipDetail.getPreferredDate())
              .preferredTime(slipDetail.getPreferredTime())
              .completionDate(slipDetail.getCompletionDate())
              .deleteDiv(slipDetail.getDeleteDiv())
              .imageUrl(slipDetail.getImageUrl())
              .messageOpenLebel(slipDetail.getMessageOpenLebel())
              .build();
  }
}
