package com.example.cocomecha_api.domain.service;


import com.example.cocomecha_api.domain.model.User;
import com.example.cocomecha_api.domain.repository.UserRepository;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {

  @NonNull
  private final UserRepository userRepository;

  public List<User> findById(String mailaddress) {
      return this.userRepository.findById(mailaddress);
  }


}
