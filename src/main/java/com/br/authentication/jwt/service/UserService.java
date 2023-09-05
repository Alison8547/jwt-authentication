package com.br.authentication.jwt.service;

import com.br.authentication.jwt.mapper.UserMapper;
import com.br.authentication.jwt.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final UserMapper mapper;


}
