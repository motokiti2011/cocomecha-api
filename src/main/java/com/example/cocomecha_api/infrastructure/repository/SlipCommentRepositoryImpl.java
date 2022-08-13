package com.example.cocomecha_api.infrastructure.repository;

import com.example.cocomecha_api.domain.model.SlipComment;
import com.example.cocomecha_api.domain.repository.SlipCommentRepository;
import com.example.cocomecha_api.infrastructure.entity.SlipCommentEntity;
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
public class SlipCommentRepositoryImpl implements SlipCommentRepository  {
  
  @NonNull
  private final SlipCommentJpaRepository slipCommentJpaRepository;

  /**
   * {@inheritDoc}
   */
  @Override
  public List<SlipComment> findById(Integer commen_id) {
      return this.slipCommentJpaRepository.findById(commen_id)
              .stream().map(SlipCommentEntity::toDomainSlipComment)
              .collect(Collectors.toList());
  }
  
  /**
   * {@inheritDoc}
   */
  @Override
  public SlipComment save(SlipComment slipComment) {
      return this.slipCommentJpaRepository.save(SlipCommentEntity.build(slipComment))
              .toDomainSlipComment();
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public void deleteById(Integer commen_id) {
      this.slipCommentJpaRepository.deleteById(commen_id);
  }

  /**
   * {@inheritDoc}
   */
  public List<SlipComment> findAll() {
      return this.slipCommentJpaRepository.findAll()
              .stream().map(SlipCommentEntity::toDomainSlipComment)
              .collect(Collectors.toList());
  }
}
