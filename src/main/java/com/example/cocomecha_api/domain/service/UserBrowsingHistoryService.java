package com.example.cocomecha_api.domain.service;

import com.example.cocomecha_api.domain.model.UserBrowsingHistory;
import com.example.cocomecha_api.domain.repository.UserBrowsingHistoryRepository;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserBrowsingHistoryService {
  @NonNull
  private final UserBrowsingHistoryRepository userBrowsingHistoryRepository;

  public List<UserBrowsingHistory> findById(Integer id) {
    return this.userBrowsingHistoryRepository.findById(id);
  }

  public UserBrowsingHistory postUser(UserBrowsingHistory userBrowsingHistory) {
    return this.userBrowsingHistoryRepository.save(userBrowsingHistory);
  }

  public UserBrowsingHistory putUser(UserBrowsingHistory userBrowsingHistory) {
    return this.userBrowsingHistoryRepository.save(userBrowsingHistory);
  }

  public void deleteUser(Integer id) {
    this.userBrowsingHistoryRepository.deleteById(id);
  }

  public List<UserBrowsingHistory> findAll() {
    return this.userBrowsingHistoryRepository.findAll();
  }
}
