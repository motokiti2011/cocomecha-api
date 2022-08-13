package com.example.cocomecha_api.infrastructure.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "permission")
public class PermissionEntity {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String name;
	private String alias;

  /**
   * ドメインオブジェクトへ変換
   *
   * @return ドメインオブジェクト
   */
  public PermissionEntity toDomainPermission() {
      return PermissionEntity.builder()
              .id(this.id)
              .name(this.name)
              .alias(this.alias)
              .build();
  }

  /**
   * ドメインオブジェクトからインスタンスを生成
   *
   * @param permission ドメインオブジェクト
   * @return Permission
   */
  public static PermissionEntity build(PermissionEntity permission) {
      return PermissionEntity.builder()
              .id(permission.getId())
              .name(permission.getName())
              .alias(permission.getAlias())
              .build();
  }
}
