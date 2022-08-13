package com.example.cocomecha_api.domain.repository;

import com.example.cocomecha_api.domain.model.SlipDetail;

import java.util.List;

public interface SlipDetailRepository {

  List<SlipDetail> findById(String slipNo);

  SlipDetail save(SlipDetail slip);

  void deleteById(String slipNo);

  List<SlipDetail> findAll();
  
}
