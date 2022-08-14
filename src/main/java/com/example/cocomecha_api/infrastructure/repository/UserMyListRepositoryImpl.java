package com.example.cocomecha_api.infrastructure.repository;

import com.example.cocomecha_api.domain.model.UserMyList;
import com.example.cocomecha_api.domain.repository.UserMyListRepository;
import com.example.cocomecha_api.infrastructure.entity.UserMyListEntity;
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
public class UserMyListRepositoryImpl implements UserMyListRepository {
  @NonNull
  private final UserMyListJpaRepository userMyListJpaRepository;

  
  /**
   * {@inheritDoc}
   */
  @Override
  public List<UserMyList> findById(String id) {
      return this.userMyListJpaRepository.findById(id)
              .stream().map(UserMyListEntity::toDomainUserMyList)
              .collect(Collectors.toList());
  }
  
  /**
   * {@inheritDoc}
   */
  @Override
  public UserMyList save(UserMyList userMyList) {
      return this.userMyListJpaRepository.save(UserMyListEntity.build(userMyList))
              .toDomainUserMyList();
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public void deleteById(String id) {
      this.userMyListJpaRepository.deleteById(id);
  }

  /**
   * {@inheritDoc}
   */
  public List<UserMyList> findAll() {
      return this.userMyListJpaRepository.findAll()
              .stream().map(UserMyListEntity::toDomainUserMyList)
              .collect(Collectors.toList());
  }
  
}
