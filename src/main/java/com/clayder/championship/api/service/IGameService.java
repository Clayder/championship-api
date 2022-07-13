package com.clayder.championship.api.service;

import com.clayder.championship.api.entity.GameEntity;
import com.clayder.championship.core.service.IServiceCore;

public interface IGameService extends IServiceCore<GameEntity, Long> {
    GameEntity createGame(Long tournamentId, Long homeTeamId, Long teamId);
    GameEntity gameStart(Long gameId);

    GameEntity timeInterval(Long gameId);

    GameEntity replacement(Long gameId, Long leavePlayerId, Long playerOutputId);

    GameEntity warning(Long gameId, Long playerId);

    GameEntity endGame(Long gameId);

    GameEntity gol(Long gameId, Long playerId);

    GameEntity addTime(Long id, Integer addTime);
}
