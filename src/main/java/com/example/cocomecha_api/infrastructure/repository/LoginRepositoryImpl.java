package com.example.cocomecha_api.infrastructure.repository;

import com.example.cocomecha_api.domain.model.Login;
import com.example.cocomecha_api.domain.repository.LoginRepository;
import com.example.cocomecha_api.infrastructure.entity.LoginEntity;
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
public class LoginRepositoryImpl implements LoginRepository {
  

  @NonNull
  private final LoginJpaRepository loginJpaRepository;

  /**
   * {@inheritDoc}
   */
  @Override
  public List<Login> findByLoginid(String loginid) {
      return this.loginJpaRepository.findByLoginid(loginid)
              .stream().map(LoginEntity::toDomainLogin)
              .collect(Collectors.toList());
  }

    /**
   * {@inheritDoc}
   */
  @Override
  public List<Login> findFirstByUserid(Integer userid) {
      return this.loginJpaRepository.findFirstByUserid(userid)
              .stream().map(LoginEntity::toDomainLogin)
              .collect(Collectors.toList());
  }

    /**
   * {@inheritDoc}
   */
  @Override
  public Login save(Login login) {
      return this.loginJpaRepository.save(LoginEntity.build(login))
              .toDomainLogin();
  }

}
