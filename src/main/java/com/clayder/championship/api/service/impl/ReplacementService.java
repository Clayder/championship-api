package com.clayder.championship.api.service.impl;

import com.clayder.championship.api.entity.ReplacementEntity;
import com.clayder.championship.api.repository.IReplacementRepository;
import com.clayder.championship.api.service.IReplacementService;
import com.clayder.championship.core.service.AbstractServiceCore;
import org.springframework.stereotype.Service;

@Service
public class ReplacementService extends AbstractServiceCore<ReplacementEntity, Long> implements IReplacementService {
    public ReplacementService(IReplacementRepository repository) {
        super(repository);
    }
}
