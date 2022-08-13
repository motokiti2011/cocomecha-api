package com.example.cocomecha_api.domain.repository;

import com.example.cocomecha_api.domain.model.SlipComment;

import java.util.List;

public interface SlipCommentRepository {

  List<SlipComment> findById(Integer slipNo);

  SlipComment save(SlipComment slip);

  void deleteById(Integer slipNo);

  List<SlipComment> findAll();
  
}
