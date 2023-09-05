package com.br.authentication.jwt.controller;

import com.br.authentication.jwt.dto.LoginRequest;
import com.br.authentication.jwt.dto.UserRequest;
import com.br.authentication.jwt.dto.UserResponse;
import com.br.authentication.jwt.service.AuthService;
import com.br.authentication.jwt.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Validated
@RestController
@RequiredArgsConstructor
public class UserAuthController {

    private final UserService userService;
    private final AuthService authService;

    @Operation(summary = "Authenticate Your Account", description = "Authenticate Your Account in the database")
    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "200", description = "Authenticate with success"),
                    @ApiResponse(responseCode = "400", description = "Bad request generated"),
                    @ApiResponse(responseCode = "403", description = "You do not have permission to access this resource."),
                    @ApiResponse(responseCode = "500", description = "An exception was generated")
            }
    )
    @PostMapping("/auth")
    public ResponseEntity<String> authentication(@Valid @RequestBody LoginRequest loginRequest) {
        return new ResponseEntity<>(authService.authentication(loginRequest), HttpStatus.OK);
    }


    @Operation(summary = "Create User Account", description = "Create user Account in the database")
    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "201", description = "Create with success"),
                    @ApiResponse(responseCode = "400", description = "Bad request generated"),
                    @ApiResponse(responseCode = "403", description = "You do not have permission to access this resource."),
                    @ApiResponse(responseCode = "500", description = "An exception was generated")
            }
    )
    @PostMapping("/create-user")
    public ResponseEntity<UserResponse> createUser(@Valid @RequestBody UserRequest userRequest) {
        return new ResponseEntity<>(userService.createUser(userRequest), HttpStatus.CREATED);
    }

    @Operation(summary = "Disabled Account", description = "Disabled Account in the database")
    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "200", description = "Disabled with success"),
                    @ApiResponse(responseCode = "400", description = "Bad request generated"),
                    @ApiResponse(responseCode = "403", description = "You do not have permission to access this resource."),
                    @ApiResponse(responseCode = "500", description = "An exception was generated")
            }
    )
    @PutMapping("/disabled-user/{idUser}")
    public ResponseEntity<UserResponse> disabledUser(@PathVariable Integer idUser) {
        return new ResponseEntity<>(userService.disabledUser(idUser), HttpStatus.OK);
    }

    @Operation(summary = "List Disabled Account", description = "List Disabled Account in the database")
    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "200", description = "Successful list"),
                    @ApiResponse(responseCode = "400", description = "Bad request generated"),
                    @ApiResponse(responseCode = "403", description = "You do not have permission to access this resource."),
                    @ApiResponse(responseCode = "500", description = "An exception was generated")
            }
    )
    @GetMapping("/list-user-disabled")
    public ResponseEntity<List<UserResponse>> listUserDisabled() {
        return new ResponseEntity<>(userService.listUserDisabled(), HttpStatus.OK);
    }
}
