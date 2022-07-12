package com.clayder.championship.api.controller;

import com.clayder.championship.api.dto.team.TeamDtoResponse;
import com.clayder.championship.api.entity.TeamEntity;
import com.clayder.championship.api.service.ITeamService;
import com.clayder.championship.core.controller.AbstractControllerCore;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/api/v1/teams")
public class TeamController extends AbstractControllerCore<TeamEntity, TeamDtoResponse, Long> {

    ITeamService service;
    public TeamController(ModelMapper modelMapper, ITeamService service) {
        super(modelMapper, service);
        this.service = service;
    }

    @Override
    protected Class<TeamDtoResponse> getDtoClass() {
        return TeamDtoResponse.class;
    }

    @Override
    protected Class<TeamEntity> getEntityClass() {
        return TeamEntity.class;
    }
}
