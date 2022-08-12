package com.example.cocomecha_api.infrastructure.entity;

import com.example.cocomecha_api.domain.model.User;
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
@Table(name = "users")
public class UserEntity {
    @Id
    private Integer userid;
    private String username;
    private Integer price;

    public User toDomainUser() {
        return User.builder()
                .userid(this.userid)
                .username(this.username)
                .price(this.price)
                .build();
    }

}
