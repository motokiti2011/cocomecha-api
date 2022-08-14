package com.example.cocomecha_api.infrastructure.entity;

import com.example.cocomecha_api.domain.model.UserMyList;
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
@Table(name = "user_mylist")
public class UserMyListEntity {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private String id;
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

  /**
   * ドメインオブジェクトへ変換
   *
   * @return ドメインオブジェクト
   */
  public UserMyList toDomainUserMyList() {
    return UserMyList.builder()
        .id(this.id)
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
        .preferredDate(this.preferredDate)
        .preferredTime(this.preferredTime)
        .completionDate(this.completionDate)
        .deleteDiv(this.deleteDiv)
        .imageUrl(this.imageUrl)
        .build();
  }

  /**
   * ドメインオブジェクトからインスタンスを生成
   *
   * @param userMyList ドメインオブジェクト
   * @return UserMyListEntity
   */
  public static UserMyListEntity build(UserMyList userMyList) {
    return UserMyListEntity.builder()
        .id(userMyList.getId())
        .slipNo(userMyList.getSlipNo())
        .userId(userMyList.getUserId())
        .title(userMyList.getTitle())
        .category(userMyList.getCategory())
        .area(userMyList.getArea())
        .price(userMyList.getPrice())
        .bidMethod(userMyList.getBidMethod())
        .bidderId(userMyList.getBidderId())
        .bidEndDate(userMyList.getBidEndDate())
        .explanation(userMyList.getExplanation())
        .preferredDate(userMyList.getPreferredDate())
        .preferredTime(userMyList.getPreferredTime())
        .completionDate(userMyList.getCompletionDate())
        .deleteDiv(userMyList.getDeleteDiv())
        .imageUrl(userMyList.getImageUrl())
        .build();
  }

}
