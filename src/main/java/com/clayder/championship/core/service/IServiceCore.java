package com.clayder.championship.core.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface IServiceCore <T, Long> {
    T save(T entity);
    Page<T> findAll(T filter, Pageable pageRequest);
    T update(T entity, Long id);
    T update(T entity);
    void delete(T entity) throws IllegalArgumentException;
    Optional<T> findById(Long id);
    T getById(Long id);
}
