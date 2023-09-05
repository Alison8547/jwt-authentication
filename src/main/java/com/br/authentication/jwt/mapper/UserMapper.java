package com.br.authentication.jwt.mapper;

import com.br.authentication.jwt.domain.UserEntity;
import com.br.authentication.jwt.dto.UserRequest;
import com.br.authentication.jwt.dto.UserResponse;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UserMapper {

    private final ModelMapper mapper;


    public UserEntity toUserEntity(UserRequest userRequest) {
        return mapper.map(userRequest, UserEntity.class);
    }

    public UserResponse toUserResponse(UserEntity userEntity) {
        return mapper.map(userEntity, UserResponse.class);
    }

}
