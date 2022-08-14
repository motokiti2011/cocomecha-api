package com.example.cocomecha_api.domain.service;

import com.example.cocomecha_api.domain.model.UserMyList;
import com.example.cocomecha_api.domain.repository.UserMyListRepository;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor

public class UserMyListService {
  @NonNull
  private final UserMyListRepository userMyListRepository;

  public List<UserMyList> findById(String slipNo) {
      return this.userMyListRepository.findById(slipNo);
  }

  public UserMyList postUser(UserMyList userVehicle) {
      return this.userMyListRepository.save(userVehicle);
  }

  public UserMyList putUser(UserMyList userVehicle) {
      return this.userMyListRepository.save(userVehicle);
  }

  public void deleteUser(String slipNo) {
      this.userMyListRepository.deleteById(slipNo);
  }

  public List<UserMyList> findAll() {
      return this.userMyListRepository.findAll();
  }
  
}
