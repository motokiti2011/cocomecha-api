package com.example.cocomecha_api.infrastructure.repository;


import com.example.cocomecha_api.domain.model.UserVehicle;
import com.example.cocomecha_api.domain.repository.UserVehicleRepository;
import com.example.cocomecha_api.infrastructure.entity.UserVehicleEntity;
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
public class UserVehicleRepositoryImpl implements UserVehicleRepository {

  @NonNull
  private final UserVehicleJpaRepository userVehicleJpaRepository;

  /**
   * {@inheritDoc}
   */
  @Override
  public List<UserVehicle> findById(Integer user_id) {
      return this.userVehicleJpaRepository.findById(user_id)
              .stream().map(UserVehicleEntity::toDomainUserVehicle)
              .collect(Collectors.toList());
  }
  
  /**
   * {@inheritDoc}
   */
  @Override
  public UserVehicle save(UserVehicle userVehicle) {
      return this.userVehicleJpaRepository.save(UserVehicleEntity.build(userVehicle))
              .toDomainUserVehicle();
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public void deleteById(Integer user_id) {
      this.userVehicleJpaRepository.deleteById(user_id);
  }

  /**
   * {@inheritDoc}
   */
  public List<UserVehicle> findAll() {
      return this.userVehicleJpaRepository.findAll()
              .stream().map(UserVehicleEntity::toDomainUserVehicle)
              .collect(Collectors.toList());
  }
}
