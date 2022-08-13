package com.example.cocomecha_api.infrastructure.repository;

  import com.example.cocomecha_api.domain.model.UserBrowsingHistory;
  import com.example.cocomecha_api.domain.repository.UserBrowsingHistoryRepository;
  import com.example.cocomecha_api.infrastructure.entity.UserBrowsingHistoryEntity;
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
  public class UserBrowsingHistoryRepositoryImpl implements UserBrowsingHistoryRepository {
  
    @NonNull
    private final UserBrowsingHistoryJpaRepository userBrowsingHistoryJpaRepository;
  
    /**
     * {@inheritDoc}
     */
    @Override
    public List<UserBrowsingHistory> findById(Integer id) {
        return this.userBrowsingHistoryJpaRepository.findById(id)
                .stream().map(UserBrowsingHistoryEntity::toDomainUserBrowsingHistory)
                .collect(Collectors.toList());
    }
    
   
    /**
     * {@inheritDoc}
     */
    @Override
    public UserBrowsingHistory save(UserBrowsingHistory userBrowsingHistory) {
        return this.userBrowsingHistoryJpaRepository.save(UserBrowsingHistoryEntity.build(userBrowsingHistory))
                .toDomainUserBrowsingHistory();
    }
  
    /**
     * {@inheritDoc}
     */
    @Override
    public void deleteById(Integer id) {
        this.userBrowsingHistoryJpaRepository.deleteById(id);
    }
  
    /**
     * {@inheritDoc}
     */
    public List<UserBrowsingHistory> findAll() {
        return this.userBrowsingHistoryJpaRepository.findAll()
                .stream().map(UserBrowsingHistoryEntity::toDomainUserBrowsingHistory)
                .collect(Collectors.toList());
    }
  }
