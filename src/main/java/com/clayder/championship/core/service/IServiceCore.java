package com.clayder.championship.core.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface IServiceCore <T, Long> {
    T save(T entity);
    T save(T entity, Long id);
    Page<T> findAll(T filter, Pageable pageRequest);
    T update(T entity, Long id);
    void delete(T entity) throws IllegalArgumentException;
    Optional<T> findById(Long id);
    T getById(Long id);
}
