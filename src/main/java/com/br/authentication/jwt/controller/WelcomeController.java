package com.br.authentication.jwt.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WelcomeController {

    @GetMapping
    public String welcome() {
        return "Welcome SpringBoot Project";
    }

    @GetMapping("/users")
    public String users() {
        return "Users authorized!";
    }

    @GetMapping("/managers")
    public String managers() {
        return "Managers authorized!";
    }

}
