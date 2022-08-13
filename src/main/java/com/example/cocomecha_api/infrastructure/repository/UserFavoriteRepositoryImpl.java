package com.example.cocomecha_api.infrastructure.repository;

import com.example.cocomecha_api.domain.model.UserFavorite;
import com.example.cocomecha_api.domain.repository.UserFavoriteRepository;
import com.example.cocomecha_api.infrastructure.entity.UserFavoriteEntity;
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
public class UserFavoriteRepositoryImpl implements UserFavoriteRepository {

  @NonNull
  private final UserFavoriteJpaRepository userFavoriteJpaRepository;

  /**
   * {@inheritDoc}
   */
  @Override
  public List<UserFavorite> findById(Integer id) {
      return this.userFavoriteJpaRepository.findById(id)
              .stream().map(UserFavoriteEntity::toDomainUserFavorite)
              .collect(Collectors.toList());
  }
  
  /**
   * {@inheritDoc}
   */
  @Override
  public UserFavorite save(UserFavorite userFavorite) {
      return this.userFavoriteJpaRepository.save(UserFavoriteEntity.build(userFavorite))
              .toDomainUserFavorite();
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public void deleteById(Integer id) {
      this.userFavoriteJpaRepository.deleteById(id);
  }

  /**
   * {@inheritDoc}
   */
  public List<UserFavorite> findAll() {
      return this.userFavoriteJpaRepository.findAll()
              .stream().map(UserFavoriteEntity::toDomainUserFavorite)
              .collect(Collectors.toList());
  }
}
