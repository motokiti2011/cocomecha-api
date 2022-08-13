package com.example.cocomecha_api.infrastructure.entity;

import com.example.cocomecha_api.domain.model.Login;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

// import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "user_login")
public class LoginEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    // @Column(name = "login_id")
    private String loginid;
    private String password;
    private String userid;
    private String mailaddress;
    private String name;
    private boolean admin;

    /**
     * ドメインオブジェクトへ変換
     *
     * @return ドメインオブジェクト
     */
    public Login toDomainLogin() {
        return Login.builder()
                .loginid(this.loginid)
                .password(this.password)
                .userid(this.userid)
                .mailaddress(this.mailaddress)
                .name(this.name)
                .admin(this.admin)
                .build();
    }


    /**
     * ドメインオブジェクトからインスタンスを生成
     *
     * @param login ドメインオブジェクト
     * @return LoginEntity
     */
    public static LoginEntity build(Login login) {
        return LoginEntity.builder()
                .loginid(login.getLoginid())
                .password(login.getPassword())
                .userid(login.getUserid())
                .mailaddress(login.getMailaddress())
                .name(login.getName())
                .build();
    }

}

