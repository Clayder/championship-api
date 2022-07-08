package com.clayder.championship.core.service;

import com.clayder.championship.core.entity.AbstractCoreEntity;
import com.clayder.championship.core.repository.IRepositoryCore;
import lombok.NoArgsConstructor;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
@NoArgsConstructor
public abstract class AbstractServiceCore<E extends AbstractCoreEntity> implements IServiceCore<E, Long> {
    private IRepositoryCore<E, Long> repository;

    public AbstractServiceCore(IRepositoryCore<E, Long> repository) {
        this.repository = repository;
    }

    public E save(E entity) {
        entity.setId(null);
        entity.setCreatedAt(LocalDateTime.now());
        entity.setUpdatedAt(LocalDateTime.now());
        return repository.save(entity);
    }

    public Page<E> findAll(E filter, Pageable pageRequest) {

        Example<E> example = Example.of(filter,
                ExampleMatcher
                        .matching()
                        .withIgnoreCase()
                        .withIgnoreNullValues()
                        .withStringMatcher(ExampleMatcher.StringMatcher.CONTAINING));

        return this.repository.findAll(example, pageRequest);

    }

     @Override
    public Optional<E> findById(Long id) {
        return repository.findById(id);
    }

    @Override
    public E update(E entity, Long id) {
        Optional<E> optional = repository.findById(id);
        if (optional.isPresent()) {
            E result = optional.get();
            entity.setId(result.getId());
            entity.setCreatedAt(result.getCreatedAt());
            entity.setUpdatedAt(LocalDateTime.now());
            return (E) repository.save(entity);
        } else {
            return null;
        }
    }

    @Override
    public void delete(E entity) throws IllegalArgumentException {
        if (entity == null || entity.getId() == null) {
            throw new IllegalArgumentException();
        }
        repository.delete(entity);
    }
}
