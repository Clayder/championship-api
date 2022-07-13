package com.clayder.championship.api.controller;

import com.clayder.championship.api.dto.tournament.TournamentDtoResponse;
import com.clayder.championship.api.entity.TournamentEntity;
import com.clayder.championship.api.service.IGameService;
import com.clayder.championship.api.service.ITournamentService;
import com.clayder.championship.core.controller.BaseAbstractControllerCore;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/api/v1/tournament")
public class TournamentController extends BaseAbstractControllerCore<TournamentEntity, TournamentDtoResponse, Long> {

    ITournamentService service;
    IGameService gameService;

    public TournamentController(ModelMapper modelMapper, ITournamentService service, IGameService gameService) {
        super(modelMapper, service);
        this.service = service;
        this.gameService = gameService;
    }

    @Override
    protected Class<TournamentDtoResponse> getDtoClass() {
        return TournamentDtoResponse.class;
    }

    @Override
    protected Class<TournamentEntity> getEntityClass() {
        return TournamentEntity.class;
    }

}
