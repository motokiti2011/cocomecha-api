package com.example.cocomecha_api.domain.service;
import com.example.cocomecha_api.domain.model.SlipVehicle;
import com.example.cocomecha_api.domain.repository.SlipVehicleRepository;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SlipVehicleService {
  @NonNull
  private final SlipVehicleRepository slipVehicleRepository;

  public List<SlipVehicle> findById(Integer slipNo) {
      return this.slipVehicleRepository.findById(slipNo);
  }

  public SlipVehicle postUser(SlipVehicle userVehicle) {
      return this.slipVehicleRepository.save(userVehicle);
  }

  public SlipVehicle putUser(SlipVehicle userVehicle) {
      return this.slipVehicleRepository.save(userVehicle);
  }

  public void deleteUser(Integer slipNo) {
      this.slipVehicleRepository.deleteById(slipNo);
  }

  public List<SlipVehicle> getUserAll() {
      return this.slipVehicleRepository.findAll();
  }
}
