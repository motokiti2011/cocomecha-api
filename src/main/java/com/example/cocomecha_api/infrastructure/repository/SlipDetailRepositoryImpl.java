package com.example.cocomecha_api.infrastructure.repository;

import com.example.cocomecha_api.domain.model.SlipDetail;
import com.example.cocomecha_api.domain.repository.SlipDetailRepository;
import com.example.cocomecha_api.infrastructure.entity.SlipDetailEntity;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Collectors;

/**
 * 永続化の実装クラス
 * ドメインオブジェクトをEntityに変換してJPAをラップする
 */
@Repository
@RequiredArgsConstructor
public class SlipDetailRepositoryImpl implements SlipDetailRepository {
  

  @NonNull
  private final SlipDetailJpaRepository slipDetailJpaRepository;

  /**
   * {@inheritDoc}
   */
  @Override
  public List<SlipDetail> findById(String slipNo) {
      return this.slipDetailJpaRepository.findById(slipNo)
              .stream().map(SlipDetailEntity::toDomainSlipDetail)
              .collect(Collectors.toList());
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public SlipDetail save(SlipDetail slipDetail) {
      return this.slipDetailJpaRepository.save(SlipDetailEntity.build(slipDetail))
              .toDomainSlipDetail();
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public void deleteById(String slipNo) {
      this.slipDetailJpaRepository.deleteById(slipNo);
  }

  /**
   * {@inheritDoc}
   */
  public List<SlipDetail> findAll() {
      return this.slipDetailJpaRepository.findAll()
              .stream().map(SlipDetailEntity::toDomainSlipDetail)
              .collect(Collectors.toList());
  }

}
