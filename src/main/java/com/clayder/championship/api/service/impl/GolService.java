package com.clayder.championship.api.service.impl;

import com.clayder.championship.api.entity.GolEntity;
import com.clayder.championship.api.repository.IGolRepository;
import com.clayder.championship.api.service.IGolService;
import com.clayder.championship.core.service.AbstractServiceCore;
import org.springframework.stereotype.Service;

@Service
public class GolService extends AbstractServiceCore<GolEntity, Long> implements IGolService {
    public GolService(IGolRepository repository) {
        super(repository);
    }
}
