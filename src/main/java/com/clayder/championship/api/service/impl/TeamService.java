package com.clayder.championship.api.service.impl;

import com.clayder.championship.api.entity.TeamEntity;
import com.clayder.championship.api.repository.ITeamRepository;
import com.clayder.championship.api.service.ITeamService;
import com.clayder.championship.core.service.AbstractServiceCore;
import org.springframework.stereotype.Service;

@Service
public class TeamService extends AbstractServiceCore<TeamEntity, Long> implements ITeamService {
    public TeamService(ITeamRepository repository) {
        super(repository);
    }
}
