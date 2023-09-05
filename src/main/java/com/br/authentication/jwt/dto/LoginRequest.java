package com.br.authentication.jwt.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class LoginRequest {

    @NotBlank
    @Schema(description = "your login email",example = "alison@hotmail.com")
    private String email;

    @NotBlank
    @Schema(description = "your password account",example = "123")
    private String password;
}
