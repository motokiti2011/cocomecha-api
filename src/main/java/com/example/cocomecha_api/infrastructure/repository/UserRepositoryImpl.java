package com.example.cocomecha_api.infrastructure.repository;

import com.example.cocomecha_api.domain.model.User;
import com.example.cocomecha_api.domain.repository.UserRepository;
import com.example.cocomecha_api.infrastructure.entity.UserEntity;

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
public class UserRepositoryImpl implements UserRepository {

  @NonNull
  private final UserJpaRepository userJpaRepository;

  /**
   * {@inheritDoc}
   */
  @Override
  public List<User> findById(String mailaddress) {
      return this.userJpaRepository.findById(mailaddress)
              .stream().map(UserEntity::toDomainUser)
              .collect(Collectors.toList());
  }
  
}
