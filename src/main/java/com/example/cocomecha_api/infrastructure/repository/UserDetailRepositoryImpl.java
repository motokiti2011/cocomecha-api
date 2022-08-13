package com.example.cocomecha_api.infrastructure.repository;

import com.example.cocomecha_api.domain.model.UserDetail;
import com.example.cocomecha_api.domain.repository.UserDetailRepository;
import com.example.cocomecha_api.infrastructure.entity.UserDetailEntity;
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
public class UserDetailRepositoryImpl implements UserDetailRepository {

    @NonNull
    private final UserDetaiJpaRepository userJpaRepository;

    /**
     * {@inheritDoc}
     */
    @Override
    public List<UserDetail> findById(Integer user_id) {
        return this.userJpaRepository.findById(user_id)
                .stream().map(UserDetailEntity::toDomainUser)
                .collect(Collectors.toList());
    }
    
    /**
     * {@inheritDoc}
     */
    @Override
    public UserDetail save(UserDetail user) {
        return this.userJpaRepository.save(UserDetailEntity.build(user))
                .toDomainUser();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void deleteById(Integer user_id) {
        this.userJpaRepository.deleteById(user_id);
    }

    /**
     * {@inheritDoc}
     */
    // @Override
    public List<UserDetail> findAll() {
        return this.userJpaRepository.findAll()
                .stream().map(UserDetailEntity::toDomainUser)
                .collect(Collectors.toList());
    }



}
