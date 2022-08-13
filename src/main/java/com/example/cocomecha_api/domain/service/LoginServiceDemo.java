package com.example.cocomecha_api.domain.service;

import com.example.cocomecha_api.domain.model.Login;
import com.example.cocomecha_api.domain.repository.LoginRepository;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 認証ユーザ取得サービスクラス
 *
 */
@Service
@RequiredArgsConstructor
public class LoginServiceDemo {
  @NonNull
  private final LoginRepository loginRepository;

  public List<Login> findByLoginid(String LoginId) {
    return this.loginRepository.findByLoginid(LoginId);
  }

}
