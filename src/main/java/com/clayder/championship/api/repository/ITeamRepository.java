package com.clayder.championship.api.repository;

import com.clayder.championship.api.entity.TeamEntity;
import com.clayder.championship.core.repository.IRepositoryCore;
import org.springframework.stereotype.Repository;

@Repository
public interface ITeamRepository extends IRepositoryCore<TeamEntity, Long> {
}
