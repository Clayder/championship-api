package com.clayder.championship.api.service.impl;

import com.clayder.championship.api.entity.WarningEntity;
import com.clayder.championship.api.repository.IWarningRepository;
import com.clayder.championship.api.service.IWarningService;
import com.clayder.championship.core.service.AbstractServiceCore;
import org.springframework.stereotype.Service;

@Service
public class WarningService extends AbstractServiceCore<WarningEntity, Long> implements IWarningService {
    public WarningService(IWarningRepository repository) {
        super(repository);
    }
}
