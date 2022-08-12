package com.example.cocomecha_api.domain.repository;

import com.example.cocomecha_api.domain.model.User;

import java.util.List;

public interface UserRepository {

    List<User> findByUserid(Integer userid);

}
