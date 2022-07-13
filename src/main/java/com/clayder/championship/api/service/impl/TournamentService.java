package com.clayder.championship.api.service.impl;

import com.clayder.championship.api.entity.TournamentEntity;
import com.clayder.championship.api.repository.ITournamentRepository;
import com.clayder.championship.api.service.ITournamentService;
import com.clayder.championship.core.service.AbstractServiceCore;
import org.springframework.stereotype.Service;

@Service
public class TournamentService extends AbstractServiceCore<TournamentEntity, Long> implements ITournamentService {
    public TournamentService(ITournamentRepository repository) {
        super(repository);
    }
}
