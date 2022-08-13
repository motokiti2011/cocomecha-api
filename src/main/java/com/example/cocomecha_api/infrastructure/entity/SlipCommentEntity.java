package com.example.cocomecha_api.infrastructure.entity;

import com.example.cocomecha_api.domain.model.SlipComment;
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
@Table(name = "slip_comment")
public class SlipCommentEntity {
  @Id
  @Column(name = "comment_id")
  private Integer commentId;
  @Column(name = "slip_no")
  private Integer slipNo;
  @Column(name = "display_order")
  private String displayOrder;
  @Column(name = "user_id")
  private Integer userId;
  private String comment;
  private String price;


  /**
   * ドメインオブジェクトへ変換
   *
   * @return ドメインオブジェクト
   */
  public SlipComment toDomainSlipComment() {
      return SlipComment.builder()
              .commentId(this.commentId)
              .slipNo(this.slipNo)
              .displayOrder(this.displayOrder)
              .userId(this.userId)
              .comment(this.comment)
              .build();
  }


  /**
   * ドメインオブジェクトからインスタンスを生成
   *
   * @param SlipComment ドメインオブジェクト
   * @return SlipCommentEntity
   */
  public static SlipCommentEntity build(SlipComment slipComment) {
      return SlipCommentEntity.builder()
              .commentId(slipComment.getCommentId())
              .slipNo(slipComment.getSlipNo())
              .displayOrder(slipComment.getDisplayOrder())
              .userId(slipComment.getUserId())
              .comment(slipComment.getComment())
              .build();
  }
}

