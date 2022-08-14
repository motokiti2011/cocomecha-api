package com.example.cocomecha_api.domain.repository;

import com.example.cocomecha_api.domain.model.UserMyList;

import java.util.List;

public interface UserMyListRepository {

  List<UserMyList> findById(String id);

  UserMyList save(UserMyList userMyList);

  void deleteById(String id);

  List<UserMyList> findAll();
  
}
