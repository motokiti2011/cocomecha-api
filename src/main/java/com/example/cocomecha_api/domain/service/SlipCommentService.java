package com.example.cocomecha_api.domain.service;

import com.example.cocomecha_api.domain.model.SlipComment;
import com.example.cocomecha_api.domain.repository.SlipCommentRepository;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SlipCommentService {
  @NonNull
  private final SlipCommentRepository slipCommentRepository;

  public List<SlipComment> findById(Integer slipNo) {
      return this.slipCommentRepository.findById(slipNo);
  }

  public SlipComment postUser(SlipComment userVehicle) {
      return this.slipCommentRepository.save(userVehicle);
  }

  public SlipComment putUser(SlipComment userVehicle) {
      return this.slipCommentRepository.save(userVehicle);
  }

  public void deleteUser(Integer slipNo) {
      this.slipCommentRepository.deleteById(slipNo);
  }

  public List<SlipComment> getUserAll() {
      return this.slipCommentRepository.findAll();
  }
}
