package com.clayder.championship.api.controller;

import com.clayder.championship.api.dto.security.LoginDTO;
import com.clayder.championship.api.dto.security.TokenDTO;
import com.clayder.championship.api.service.ITokenService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/v1/auth")
public class SecurityController {

    private AuthenticationManager authManager;

    private ITokenService tokenService;

    public SecurityController(AuthenticationManager authManager, ITokenService tokenService) {
        this.authManager = authManager;
        this.tokenService = tokenService;
    }

    @PostMapping
    public ResponseEntity<TokenDTO> authenticate(@RequestBody @Valid LoginDTO form) {
        UsernamePasswordAuthenticationToken dadosLogin = form.convert();

        try {
            Authentication authentication = authManager.authenticate(dadosLogin);
            String token = tokenService.createToken(authentication);
            return ResponseEntity.ok(new TokenDTO(token, "Bearer"));
        } catch (AuthenticationException e) {
            return ResponseEntity.badRequest().build();
        }
    }

}

