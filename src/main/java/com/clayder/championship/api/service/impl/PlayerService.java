package com.clayder.championship.api.service.impl;

import com.clayder.championship.api.entity.PlayerEntity;
import com.clayder.championship.api.entity.TeamEntity;
import com.clayder.championship.api.repository.IPlayerRepository;
import com.clayder.championship.api.service.IPlayerService;
import com.clayder.championship.core.service.AbstractServiceCore;
import org.springframework.stereotype.Service;

@Service
public class PlayerService extends AbstractServiceCore<PlayerEntity, Long> implements IPlayerService {

    private final TeamService teamService;

    public PlayerService(
            IPlayerRepository repository,
            TeamService teamService
    ) {
        super(repository);
        this.teamService = teamService;
    }

    @Override
    public PlayerEntity save(PlayerEntity entity, Long id) {
        TeamEntity teamEntity = this.teamService.getById(id);
        entity.setTeam(teamEntity);
        return super.save(entity);
    }
}
