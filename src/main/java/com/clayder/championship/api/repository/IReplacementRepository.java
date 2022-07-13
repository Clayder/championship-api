package com.clayder.championship.api.repository;

import com.clayder.championship.api.entity.ReplacementEntity;
import com.clayder.championship.core.repository.IRepositoryCore;
import org.springframework.stereotype.Repository;

@Repository
public interface IReplacementRepository extends IRepositoryCore<ReplacementEntity, Long> {
}
