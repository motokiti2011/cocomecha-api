package com.example.cocomecha_api.domain.repository;

import com.example.cocomecha_api.domain.model.UserDetail;

import java.util.List;

public interface UserDetailRepository {

    List<UserDetail> findById(Integer user_id);

    UserDetail save(UserDetail user);

    void deleteById(Integer user_id);

    List<UserDetail> findAll();

}