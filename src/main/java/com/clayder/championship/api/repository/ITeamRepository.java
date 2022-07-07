package com.clayder.championship.api.repository;

import com.clayder.championship.api.entity.TeamEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ITeamRepository extends JpaRepository<TeamEntity, Long> {
}
