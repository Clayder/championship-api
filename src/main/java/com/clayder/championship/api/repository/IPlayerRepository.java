package com.clayder.championship.api.repository;

import com.clayder.championship.api.entity.PlayerEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IPlayerRepository extends JpaRepository<PlayerEntity, Long> {
}
