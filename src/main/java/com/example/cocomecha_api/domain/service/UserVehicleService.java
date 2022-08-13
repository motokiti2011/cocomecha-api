package com.example.cocomecha_api.domain.service;

import com.example.cocomecha_api.domain.model.UserVehicle;
import com.example.cocomecha_api.domain.repository.UserVehicleRepository;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserVehicleService {
  @NonNull
  private final UserVehicleRepository userVehicleRepository;

  public List<UserVehicle> findById(Integer user_id) {
      return this.userVehicleRepository.findById(user_id);
  }

  public UserVehicle postUser(UserVehicle userVehicle) {
      return this.userVehicleRepository.save(userVehicle);
  }

  public UserVehicle putUser(UserVehicle userVehicle) {
      return this.userVehicleRepository.save(userVehicle);
  }

  public void deleteUser(Integer user_id) {
      this.userVehicleRepository.deleteById(user_id);
  }

  public List<UserVehicle> getUserAll() {
      return this.userVehicleRepository.findAll();
  }
}
