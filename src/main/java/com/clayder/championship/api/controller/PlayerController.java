package com.clayder.championship.api.controller;

import com.clayder.championship.api.dto.player.PlayerDtoRequest;
import com.clayder.championship.api.dto.player.PlayerDtoResponse;
import com.clayder.championship.api.entity.PlayerEntity;
import com.clayder.championship.api.service.IPlayerService;
import com.clayder.championship.core.controller.AbstractControllerCore;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
@RequestMapping("/api/v1/players")
public class PlayerController extends AbstractControllerCore<PlayerEntity, PlayerDtoResponse, Long> {

    IPlayerService service;
    public PlayerController(ModelMapper modelMapper, IPlayerService service) {
        super(modelMapper, service);
        this.service = service;
    }

    @Override
    protected Class<PlayerDtoResponse> getDtoClass() {
        return PlayerDtoResponse.class;
    }

    @Override
    protected Class<PlayerEntity> getEntityClass() {
        return PlayerEntity.class;
    }

    @PostMapping("/teams/{idTeam}")
    public ResponseEntity<PlayerDtoResponse> create(
            @PathVariable Long idTeam,
            @Valid @RequestBody PlayerDtoRequest dto
    ) {
        PlayerEntity newPlayer = service.save(
                modelMapper.map(dto, PlayerEntity.class),
                idTeam
        );

        return ResponseEntity.ok(modelMapper.map(newPlayer, PlayerDtoResponse.class));
    }
}
