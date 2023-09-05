package com.br.authentication.jwt.dto;

import com.br.authentication.jwt.domain.CargoEntity;
import lombok.*;

import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserRequest {

    private String login;
    private String senha;
    private Set<CargoEntity> cargos;
}
