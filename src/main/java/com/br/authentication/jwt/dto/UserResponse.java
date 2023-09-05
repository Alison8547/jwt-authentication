package com.br.authentication.jwt.dto;

import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserResponse {

    private Integer id;
    private String name;
    private String username;
    private List<String> roles = new ArrayList<>();
}
