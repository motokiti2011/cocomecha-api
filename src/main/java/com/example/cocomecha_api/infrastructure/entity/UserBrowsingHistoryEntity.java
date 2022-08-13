package com.example.cocomecha_api.infrastructure.entity;

import com.example.cocomecha_api.domain.model.UserBrowsingHistory;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "user_browsing_history")
public class UserBrowsingHistoryEntity {
  @Id
  private Integer id;
  @Column(name = "user_id")
  private String userId;
  @Column(name = "slip_no")
  private String slipNo;
  private String title;
  @Column(name = "image_url")
  private String imageUrl;

  /**
   * ドメインオブジェクトへ変換
   *
   * @return ドメインオブジェクト
   */
  public UserBrowsingHistory toDomainUserBrowsingHistory() {
    return UserBrowsingHistory.builder()
    .id(this.id)
    .userId(this.userId)
    .slipNo(this.slipNo)
    .title(this.title)
    .imageUrl(this.imageUrl)
    .build();
  }

  /**
   * ドメインオブジェクトからインスタンスを生成
   *
   * @param user ドメインオブジェクト
   * @return UserBrowsingHistoryEntity
   */
  public static UserBrowsingHistoryEntity build(UserBrowsingHistory userBrowsingHistory) {
    return UserBrowsingHistoryEntity.builder()
    .id(userBrowsingHistory.getId())
    .userId(userBrowsingHistory.getUserId())
    .slipNo(userBrowsingHistory.getSlipNo())
    .title(userBrowsingHistory.getTitle())
    .imageUrl(userBrowsingHistory.getImageUrl())
    .build();
  }
}
