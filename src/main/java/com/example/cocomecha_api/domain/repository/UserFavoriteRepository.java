package com.example.cocomecha_api.domain.repository;

import com.example.cocomecha_api.domain.model.UserFavorite;

import java.util.List;

public interface UserFavoriteRepository {
  
  List<UserFavorite> findById(Integer id);

  UserFavorite save(UserFavorite userFavorite);

  void deleteById(Integer id);

  List<UserFavorite> findAll();
}
