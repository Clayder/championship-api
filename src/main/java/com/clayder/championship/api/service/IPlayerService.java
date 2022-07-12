package com.clayder.championship.api.service;

import com.clayder.championship.api.entity.PlayerEntity;
import com.clayder.championship.core.service.IServiceCore;

public interface IPlayerService extends IServiceCore<PlayerEntity, Long> {
    PlayerEntity save(PlayerEntity entity, Long id);
}
