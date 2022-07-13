package com.clayder.championship.api.service.impl;

import com.clayder.championship.api.entity.GameEntity;
import com.clayder.championship.api.entity.GolEntity;
import com.clayder.championship.api.entity.ReplacementEntity;
import com.clayder.championship.api.entity.WarningEntity;
import com.clayder.championship.api.service.*;
import com.clayder.championship.core.repository.IRepositoryCore;
import com.clayder.championship.core.service.AbstractServiceCore;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class GameService extends AbstractServiceCore<GameEntity, Long> implements IGameService {

    ITeamService teamService;
    ITournamentService tournamentService;
    IReplacementService replacementService;
    IPlayerService playerService;

    IWarningService warningService;
    IGolService golService;

    public GameService(IRepositoryCore<GameEntity, Long> repository, ITeamService teamService, ITournamentService tournamentService, IReplacementService replacementService, IPlayerService playerService, IWarningService warningService, IGolService golService) {
        super(repository);
        this.teamService = teamService;
        this.tournamentService = tournamentService;
        this.replacementService = replacementService;
        this.playerService = playerService;
        this.warningService = warningService;
        this.golService = golService;
    }

    @Override
    public GameEntity createGame(Long tournamentId, Long homeTeamId, Long teamId) {
        var homeTeam = teamService.getById(homeTeamId);
        var team = teamService.getById(teamId);
        var tournament = tournamentService.getById(tournamentId);

        GameEntity game = GameEntity.builder()
                .homeTeam(homeTeam)
                .team(team)
                .tournament(tournament)
                .build();

        return this.save(game);
    }

    @Override
    public GameEntity gameStart(Long gameId) {
        var game = this.getById(gameId);
        game.setStart(LocalDateTime.now());
        return this.update(game);
    }

    @Override
    public GameEntity timeInterval(Long gameId) {
        var game = this.getById(gameId);
        game.setIntervalGame(LocalDateTime.now());
        return this.update(game);
    }

    @Override
    public GameEntity replacement(Long gameId, Long leavePlayerId, Long playerOutputId) {
        var game = this.getById(gameId);
        var leavePlayer = playerService.getById(leavePlayerId);
        var playerOut = playerService.getById(playerOutputId);
        var replacement = ReplacementEntity.builder()
                .game(game)
                .leavePlayer(leavePlayer)
                .playerOutput(playerOut)
                .build();
        replacementService.save(replacement);
        return game;
    }

    @Override
    public GameEntity warning(Long gameId, Long playerId) {
        var game = this.getById(gameId);
        var player = playerService.getById(playerId);
        var warning = WarningEntity.builder()
                .player(player)
                .game(game)
                .build();
        warningService.save(warning);
        return game;
    }

    @Override
    public GameEntity endGame(Long gameId) {
        var game = this.getById(gameId);
        game.setFinished(LocalDateTime.now());
        return this.update(game);
    }

    @Override
    public GameEntity gol(Long gameId, Long playerId) {
        var game = this.getById(gameId);
        var player = playerService.getById(playerId);

        var gol = GolEntity.builder()
                .game(game)
                .player(player)
                .build();

        golService.save(gol);
        return game;
    }

    @Override
    public GameEntity addTime(Long id, Integer addTime) {
        var game = this.getById(id);
        game.setTimeAddition(game.getTimeAddition() + addTime);
        return this.update(game);
    }
}