package com.example.cocomecha_api.infrastructure.entity;

import com.example.cocomecha_api.domain.model.User;
import com.example.cocomecha_api.domain.model.Role;
import lombok.Builder;
import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

import java.util.List;
import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnore;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "user")
public class UserEntity  implements Serializable {
	private static final long serialVersionUID = 1L;
  @Id
  private String mailaddress;
  /** パスワード（認証時使用。DBにはハッシュ化して格納）*/
	@JsonIgnore
  private String encodedPassword;
  private String name;
  	/** 保有するロールリスト*/
	@ManyToMany(fetch=FetchType.LAZY)
	@JoinTable(
			name="user_has_role",			
			joinColumns=@JoinColumn(name="user_name",referencedColumnName="name"),
			inverseJoinColumns=@JoinColumn(name="role_id",referencedColumnName="id")
			)
  private List<Role> roles;
  
  
  /**
   * ドメインオブジェクトからインスタンスを生成
   *
   * @param user ドメインオブジェクト
   * @return User
   */
  public User toDomainUser() {
    return User.builder()
        .mailaddress(this.mailaddress)
        .encodedPassword(this.encodedPassword)
        .name(this.name)
        .roles(this.roles)
        .build();
  }

  /**
   * ドメインオブジェクトからインスタンスを生成
   *
   * @param user ドメインオブジェクト
   * @return UserEntity
   */
  public static UserEntity build(User user) {
    return UserEntity.builder()
        .mailaddress(user.getMailaddress())
        .encodedPassword(user.getEncodedPassword())
        .name(user.getName())
        .roles(user.getRoles())
        .build();
  }
}