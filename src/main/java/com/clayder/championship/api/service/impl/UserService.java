package com.clayder.championship.api.service.impl;

import com.clayder.championship.api.entity.User;
import com.clayder.championship.api.repository.IUserRepository;
import com.clayder.championship.api.service.IUserService;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService implements IUserService {

    private IUserRepository repository;

    public UserService(IUserRepository repository) {
        this.repository = repository;
    }

    @Override
    public User getById(Long id) {
        Optional<User> obj = repository.findById(id);
        return obj.orElseThrow(() -> new BadCredentialsException(""));
    }
}
