package com.example.cocomecha_api.infrastructure.entity;

import com.example.cocomecha_api.domain.model.Permission;
import lombok.Builder;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.GeneratedValue;

import java.util.List;
import java.io.Serializable;

@Data
@Builder
@Entity
@Table(name = "role")
public class RoleEntity implements Serializable{
  private static final long serialVersionUID = 1L;

  @Id
  @GeneratedValue
	private Integer id;
  private String name;
  private String alias;
	@ManyToMany(fetch=FetchType.LAZY)
	@JoinTable(
			name="role_has_permission",
			joinColumns=@JoinColumn(name="role_name",referencedColumnName="name"),
			inverseJoinColumns=@JoinColumn(name="permission_id",referencedColumnName="id")
			)
	List<Permission> permissions;	


  public RoleEntity toDomainRole() {
    return RoleEntity.builder()
        .id(this.id)
        .name(this.name)
        .alias(this.alias)
        .permissions(this.permissions)
        .build();
  }

  /**
   * ドメインオブジェクトからインスタンスを生成
   *
   * @param RoleEntity ドメインオブジェクト
   * @return RoleEntity
   */
  public static RoleEntity build(RoleEntity role) {
    return RoleEntity.builder()
        .id(role.getId())
        .name(role.getName())
        .alias(role.getAlias())
        .permissions(role.getPermissions())
        .build();
  }
  
}
