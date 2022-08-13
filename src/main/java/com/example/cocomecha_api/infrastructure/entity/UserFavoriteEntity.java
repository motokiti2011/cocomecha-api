package com.example.cocomecha_api.infrastructure.entity;

import com.example.cocomecha_api.domain.model.UserFavorite;
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
@Table(name = "user_favorite")
public class UserFavoriteEntity {
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
    public UserFavorite toDomainUserFavorite() {
        return UserFavorite.builder()
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
     * @return UserFavoriteEntity
     */
    public static UserFavoriteEntity build(UserFavorite userFavorite) {
        return UserFavoriteEntity.builder()
                .id(userFavorite.getId())
                .userId(userFavorite.getUserId())
                .slipNo(userFavorite.getSlipNo())
                .title(userFavorite.getTitle())
                .imageUrl(userFavorite.getImageUrl())
                .build();
    }

}
