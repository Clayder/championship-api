package com.clayder.championship.api.controller;

import com.clayder.championship.api.dto.team.TeamDtoResponse;
import com.clayder.championship.api.entity.TeamEntity;
import com.clayder.championship.api.service.TeamService;
import com.clayder.championship.core.controller.AbstractControllerCore;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/api/v1/teams")
public class TeamController extends AbstractControllerCore<TeamEntity, TeamDtoResponse, Long> {

    public TeamController(ModelMapper modelMapper, TeamService service) {
        super(modelMapper, service);
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
