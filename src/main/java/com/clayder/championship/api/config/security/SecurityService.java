package com.clayder.championship.api.config.security;

import com.clayder.championship.api.entity.User;
import com.clayder.championship.api.repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class SecurityService implements UserDetailsService {

    @Autowired
    private IUserRepository repository;

    @Override
    public User loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> usuario = repository.findByEmail(username);
        if (usuario.isPresent()) {
            return usuario.get();
        }

        throw new UsernameNotFoundException("Invalid data!");
    }

}
