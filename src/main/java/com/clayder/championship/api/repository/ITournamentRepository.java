package com.clayder.championship.api.repository;

import com.clayder.championship.api.entity.TournamentEntity;
import com.clayder.championship.core.repository.IRepositoryCore;
import org.springframework.stereotype.Repository;

@Repository
public interface ITournamentRepository extends IRepositoryCore<TournamentEntity, Long> {
}
