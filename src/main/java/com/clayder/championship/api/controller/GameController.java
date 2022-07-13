package com.clayder.championship.api.controller;

import com.clayder.championship.api.dto.game.GameAddTimeDtoRequest;
import com.clayder.championship.api.dto.game.GameDtoRequest;
import com.clayder.championship.api.dto.game.GameDtoResponse;
import com.clayder.championship.api.dto.gol.GolDtoRequest;
import com.clayder.championship.api.dto.replacement.ReplacementDtoRequest;
import com.clayder.championship.api.dto.warning.WarningDtoRequest;
import com.clayder.championship.api.entity.GameEntity;
import com.clayder.championship.api.service.IGameService;
import com.clayder.championship.core.controller.BaseAbstractControllerCore;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
@RequestMapping("/api/v1/game")
public class GameController extends BaseAbstractControllerCore<GameEntity, GameDtoResponse, Long> {
    IGameService service;

    public GameController(ModelMapper modelMapper, IGameService service) {
        super(modelMapper, service);
        this.service = service;
    }

    @Override
    protected Class<GameDtoResponse> getDtoClass() {
        return GameDtoResponse.class;
    }

    @Override
    protected Class<GameEntity> getEntityClass() {
        return GameEntity.class;
    }

    @PostMapping("/tournament/{idTournament}")
    public ResponseEntity<GameDtoResponse> create(
            @Valid @RequestBody GameDtoRequest dto,
            @PathVariable Long idTournament
    ) {
        GameEntity game = service.createGame(idTournament, dto.getHomeTeamId(), dto.getTeamId());
        return ResponseEntity.ok(modelMapper.map(game, GameDtoResponse.class));
    }

    @PostMapping("/{id}/event/start")
    public ResponseEntity<GameDtoResponse> gameStart(
            @PathVariable Long id
    ) {
        GameEntity game = service.gameStart(id);
        return ResponseEntity.ok(modelMapper.map(game, GameDtoResponse.class));
    }

    @PostMapping("/{id}/event/time/interval")
    public ResponseEntity<GameDtoResponse> interval(
            @PathVariable Long id
    ) {
        GameEntity game = service.timeInterval(id);
        return ResponseEntity.ok(modelMapper.map(game, GameDtoResponse.class));
    }

    @PostMapping("/{id}/event/add/time")
    public ResponseEntity<GameDtoResponse> addTime(
            @Valid @RequestBody GameAddTimeDtoRequest dto,
            @PathVariable Long id
    ) {
        GameEntity game = service.addTime(id, dto.getAddTime());
        return ResponseEntity.ok(modelMapper.map(game, GameDtoResponse.class));
    }

    @PostMapping("/{id}/event/replacement")
    public ResponseEntity<GameDtoResponse> replacement(
            @PathVariable Long id,
            @Valid @RequestBody ReplacementDtoRequest dto
    ) {
        GameEntity game = service.replacement(id, dto.getLeavePlayerId(), dto.getPlayerOutputId());
        return ResponseEntity.ok(modelMapper.map(game, GameDtoResponse.class));
    }

    @PostMapping("/{id}/event/warning")
    public ResponseEntity<GameDtoResponse> warning(
            @PathVariable Long id,
            @Valid @RequestBody WarningDtoRequest dto
    ) {
        GameEntity game = service.warning(id, dto.getPlayerId());
        return ResponseEntity.ok(modelMapper.map(game, GameDtoResponse.class));
    }

    @PostMapping("/{id}/event/end/game")
    public ResponseEntity<GameDtoResponse> game(
            @PathVariable Long id
    ) {
        GameEntity game = service.endGame(id);
        return ResponseEntity.ok(modelMapper.map(game, GameDtoResponse.class));
    }

    @PostMapping("/{id}/event/gol")
    public ResponseEntity<GameDtoResponse> gol(
            @PathVariable Long id,
            @Valid @RequestBody GolDtoRequest dto
    ) {
        GameEntity game = service.gol(id, dto.getPlayerId());
        return ResponseEntity.ok(modelMapper.map(game, GameDtoResponse.class));
    }
}
