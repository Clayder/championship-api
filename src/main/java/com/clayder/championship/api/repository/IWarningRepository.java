package com.clayder.championship.api.repository;

import com.clayder.championship.api.entity.WarningEntity;
import com.clayder.championship.core.repository.IRepositoryCore;
import org.springframework.stereotype.Repository;

@Repository
public interface IWarningRepository extends IRepositoryCore<WarningEntity, Long> {
}
