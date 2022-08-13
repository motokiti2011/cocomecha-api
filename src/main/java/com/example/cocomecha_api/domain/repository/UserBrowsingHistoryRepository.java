package com.example.cocomecha_api.domain.repository;

import com.example.cocomecha_api.domain.model.UserBrowsingHistory;

import java.util.List;

public interface UserBrowsingHistoryRepository {
  List<UserBrowsingHistory> findById(Integer id);
  
  UserBrowsingHistory save(UserBrowsingHistory userBrowsingHistory);

  void deleteById(Integer id);

  List<UserBrowsingHistory> findAll();
}
