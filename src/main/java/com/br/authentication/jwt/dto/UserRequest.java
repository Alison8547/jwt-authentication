package com.br.authentication.jwt.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserRequest {

    @NotBlank
    @Email
    @Schema(description = "your email account", example = "alison@hotmail.com")
    private String email;

    @NotBlank
    @Schema(description = "your password account", example = "123")
    private String password;

    @NotNull
    @NotEmpty
    @Schema(description = "your list cargos of account", example = "[1]")
    private List<Integer> cargos;
}
