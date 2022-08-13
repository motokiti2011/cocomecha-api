package com.example.cocomecha_api.infrastructure.entity;

import com.example.cocomecha_api.domain.model.UserDetail;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "user_detail")
public class UserDetailEntity {
    @Id
    private Integer user_id;
    private String user_name;
    private String mail_adress;
    private String area;
    private String corporation_div;
    private String office_name;
    private String introduction;


    /**
     * ドメインオブジェクトへ変換
     *
     * @return ドメインオブジェクト
     */
    public UserDetail toDomainUser() {
        return UserDetail.builder()
                .user_id(this.user_id)
                .user_name(this.user_name)
                .mail_adress(this.mail_adress)
                .area(this.area)
                .corporation_div(this.corporation_div)
                .office_name(this.office_name)
                .introduction(this.introduction)
                .build();
    }


    /**
     * ドメインオブジェクトからインスタンスを生成
     *
     * @param user ドメインオブジェクト
     * @return UserEntity
     */
    public static UserDetailEntity build(UserDetail user) {
        return UserDetailEntity.builder()
                .user_id(user.getUser_id())
                .user_name(user.getUser_name())
                .area(user.getArea())
                .mail_adress(user.getMail_adress())
                .corporation_div(user.getCorporation_div())
                .office_name(user.getOffice_name())
                .introduction(user.getIntroduction())
                .build();
    }

}
