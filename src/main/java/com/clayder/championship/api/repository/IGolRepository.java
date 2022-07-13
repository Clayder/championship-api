package com.clayder.championship.api.repository;

import com.clayder.championship.api.entity.GolEntity;
import com.clayder.championship.core.repository.IRepositoryCore;
import org.springframework.stereotype.Repository;

@Repository
public interface IGolRepository extends IRepositoryCore<GolEntity, Long> {
}
