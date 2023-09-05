package com.br.authentication.jwt.service;

import com.br.authentication.jwt.domain.UserEntity;
import com.br.authentication.jwt.dto.UserRequest;
import com.br.authentication.jwt.dto.UserResponse;
import com.br.authentication.jwt.exception.BusinessException;
import com.br.authentication.jwt.mapper.UserMapper;
import com.br.authentication.jwt.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final CargoService cargoService;
    private final UserMapper mapper;
    private static final Integer USER_ACTIVATED = 1;
    private static final Integer USER_DISABLED = 0;
    private final PasswordEncoder passwordEncoder;


    public UserResponse createUser(UserRequest userRequest) {
        UserEntity userEntity = mapper.toUserEntity(userRequest);
        String pass = userEntity.getPassword();

        for (Integer idCargo : userRequest.getCargos()) {
            userEntity.getCargos().add(cargoService.findCargo(idCargo));
        }

        userEntity.setPassword(passwordEncoder.encode(pass));
        userEntity.setActive(USER_ACTIVATED);
        userRepository.save(userEntity);
        log.info("User create with success!");

        return mapper.toUserResponse(userEntity);
    }


    public UserEntity findUserEmail(String email) {
        return userRepository.findByEmail(email)
                .orElseThrow(() -> new BusinessException("Email not found!"));
    }

}
