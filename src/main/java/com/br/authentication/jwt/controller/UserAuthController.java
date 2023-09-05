package com.br.authentication.jwt.controller;

import com.br.authentication.jwt.dto.LoginRequest;
import com.br.authentication.jwt.dto.UserRequest;
import com.br.authentication.jwt.dto.UserResponse;
import com.br.authentication.jwt.service.AuthService;
import com.br.authentication.jwt.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@Validated
@RestController
@RequiredArgsConstructor
public class UserAuthController {

    private final UserService userService;
    private final AuthService authService;


    @PostMapping("/auth")
    public String authentication(@Valid @RequestBody LoginRequest loginRequest) {
        return authService.authentication(loginRequest);
    }


    @PostMapping("/create-user")
    public ResponseEntity<UserResponse> createUser(@Valid @RequestBody UserRequest userRequest) {
        return new ResponseEntity<>(userService.createUser(userRequest), HttpStatus.CREATED);
    }
}
