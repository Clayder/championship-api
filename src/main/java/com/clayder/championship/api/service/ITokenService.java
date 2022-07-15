package com.clayder.championship.api.service;

import com.clayder.championship.api.entity.User;
import org.springframework.security.core.Authentication;

public interface ITokenService {
    String createToken(Authentication authentication);

    boolean isTokenValid(String token);

    User getUser(String token);
}
