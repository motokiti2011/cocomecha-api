package com.example.cocomecha_api.domain.repository;

import com.example.cocomecha_api.domain.model.SlipVehicle;

import java.util.List;

public interface SlipVehicleRepository {
  
  List<SlipVehicle> findById(Integer slipNo);

  SlipVehicle save(SlipVehicle slip);

  void deleteById(Integer slipNo);

  List<SlipVehicle> findAll();
  
}
