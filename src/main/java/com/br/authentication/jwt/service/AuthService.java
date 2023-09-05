package com.br.authentication.jwt.service;

import com.br.authentication.jwt.domain.UserEntity;
import com.br.authentication.jwt.dto.LoginRequest;
import com.br.authentication.jwt.security.TokenService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final TokenService tokenService;
    private final AuthenticationManager authenticationManager;


    public String authentication(LoginRequest loginRequest) {

        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(loginRequest.getEmail(), loginRequest.getPassword());

        Authentication authenticate = authenticationManager.authenticate(authenticationToken);

        Object principal = authenticate.getPrincipal();
        UserEntity userEntity = (UserEntity) principal;

        return tokenService.getToken(userEntity);
    }
}
