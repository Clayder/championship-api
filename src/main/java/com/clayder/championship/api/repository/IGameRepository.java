package com.clayder.championship.api.repository;

import com.clayder.championship.api.entity.GameEntity;
import com.clayder.championship.core.repository.IRepositoryCore;
import org.springframework.stereotype.Repository;

@Repository
public interface IGameRepository extends IRepositoryCore<GameEntity, Long> {
}
