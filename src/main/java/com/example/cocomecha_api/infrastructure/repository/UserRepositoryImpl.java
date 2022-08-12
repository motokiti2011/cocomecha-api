package com.example.cocomecha_api.infrastructure.repository;

import com.example.cocomecha_api.domain.model.User;
import com.example.cocomecha_api.domain.repository.UserRepository;
import com.example.cocomecha_api.infrastructure.entity.UserEntity;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Collectors;

@Repository
@RequiredArgsConstructor
public class UserRepositoryImpl implements UserRepository {

    @NonNull
    private final UserJpaRepository userJpaRepository;

    @Override
    public List<User> findByUserid(Integer userid) {
        return this.userJpaRepository.findByUserid(userid)
                .stream().map(UserEntity::toDomainUser)
                .collect(Collectors.toList());
    }
}
