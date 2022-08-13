package com.example.cocomecha_api.domain.repository;

import com.example.cocomecha_api.domain.model.UserVehicle;

import java.util.List;

public interface UserVehicleRepository {
  
  List<UserVehicle> findById(Integer user_id);

  UserVehicle save(UserVehicle user_vehicle);

  void deleteById(Integer user_id);

  List<UserVehicle> findAll();
}
