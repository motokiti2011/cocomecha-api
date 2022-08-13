package com.example.cocomecha_api.infrastructure.repository;

import com.example.cocomecha_api.domain.model.SlipVehicle;
import com.example.cocomecha_api.domain.repository.SlipVehicleRepository;
import com.example.cocomecha_api.infrastructure.entity.SlipVehicleEntity;
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
public class SlipVehicleRepositoryImpl implements SlipVehicleRepository {

  @NonNull
  private final SlipVehicleJpaRepository slipVehicleJpaRepository;

  /**
   * {@inheritDoc}
   */
  @Override
  public List<SlipVehicle> findById(Integer slipNo) {
      return this.slipVehicleJpaRepository.findById(slipNo)
              .stream().map(SlipVehicleEntity::toDomainSlipVehicle)
              .collect(Collectors.toList());
  }
  
  /**
   * {@inheritDoc}
   */
  @Override
  public SlipVehicle save(SlipVehicle slipVehicle) {
      return this.slipVehicleJpaRepository.save(SlipVehicleEntity.build(slipVehicle))
              .toDomainSlipVehicle();
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public void deleteById(Integer slipNo) {
      this.slipVehicleJpaRepository.deleteById(slipNo);
  }

  /**
   * {@inheritDoc}
   */
  public List<SlipVehicle> findAll() {
      return this.slipVehicleJpaRepository.findAll()
              .stream().map(SlipVehicleEntity::toDomainSlipVehicle)
              .collect(Collectors.toList());
  }
}
