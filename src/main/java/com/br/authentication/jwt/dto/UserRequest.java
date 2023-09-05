package com.br.authentication.jwt.dto;

import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserRequest {

    private String name;
    private String username;
    private String password;
    private List<String> roles = new ArrayList<>();
}
