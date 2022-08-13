package com.example.cocomecha_api.domain.repository;

import com.example.cocomecha_api.domain.model.Login;
import java.util.List;

// import java.util.Optional;

public interface LoginRepository {
  List<Login> findByLoginid(String loginid);

  List<Login> findFirstByUserid(Integer userid);

  Login save(Login login);
}
