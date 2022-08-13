package com.example.cocomecha_api.domain.service;

import com.example.cocomecha_api.domain.model.UserDetail;
import com.example.cocomecha_api.domain.repository.UserDetailRepository;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserDetailService {

    @NonNull
    private final UserDetailRepository UserRepository;

    public List<UserDetail> findById(Integer user_id) {
        return this.UserRepository.findById(user_id);
    }

    public UserDetail postUser(UserDetail user) {
        return this.UserRepository.save(user);
    }

    public UserDetail putUser(UserDetail user) {
        return this.UserRepository.save(user);
    }

    public void deleteUser(Integer user_id) {
        this.UserRepository.deleteById(user_id);
    }

    public List<UserDetail> getUserAll() {
        return this.UserRepository.findAll();
    }

}
