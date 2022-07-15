package com.clayder.championship.api.service.impl;

import com.clayder.championship.api.entity.User;
import com.clayder.championship.api.service.ITokenService;
import com.clayder.championship.api.service.IUserService;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class TokenService implements ITokenService {

    @Value("${api.jwt.secret}")
    private String secret;

    @Value("${api.jwt.expiration}")
    private String expiration;

    private IUserService userService;

    public TokenService(IUserService userService) {
        this.userService = userService;
    }

    @Override
    public String createToken(Authentication authentication) {
        User user = (User) authentication.getPrincipal();
        Date today = new Date();
        Date dateExpiration = new Date(today.getTime() + Long.parseLong(expiration));

        return Jwts.builder()
                .setIssuer("API")
                .setSubject(user.getId().toString())
                .setIssuedAt(today)
                .setExpiration(dateExpiration)
                .signWith(SignatureAlgorithm.HS256, secret)
                .compact();
    }

    @Override
    public boolean isTokenValid(String token) {
        try {
            Jwts.parser().setSigningKey(this.secret).parseClaimsJws(token);
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    @Override
    public User getUser(String token) {
        Claims body = Jwts.parser().setSigningKey(this.secret).parseClaimsJws(token).getBody();
        return this.userService.getById(Long.parseLong(body.getSubject()));
    }
}
