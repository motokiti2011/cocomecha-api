package com.example.cocomecha_api.domain.service;

  
import com.example.cocomecha_api.domain.model.UserFavorite;
import com.example.cocomecha_api.domain.repository.UserFavoriteRepository;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserFavoriteService {
  @NonNull
  private final UserFavoriteRepository userFavoriteRepository;

  public List<UserFavorite> findById(Integer id) {
      return this.userFavoriteRepository.findById(id);
  }

  public UserFavorite postUser(UserFavorite userFavorite) {
      return this.userFavoriteRepository.save(userFavorite);
  }

  public UserFavorite putUser(UserFavorite userFavorite) {
      return this.userFavoriteRepository.save(userFavorite);
  }

  public void deleteUser(Integer id) {
      this.userFavoriteRepository.deleteById(id);
  }

  public List<UserFavorite> findAll() {
      return this.userFavoriteRepository.findAll();
  }
}
