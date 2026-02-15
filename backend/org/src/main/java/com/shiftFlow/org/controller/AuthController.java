package com.shiftFlow.org.controller;

import com.shiftFlow.org.service.AuthService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/user")
public class AuthController {
    private final AuthService authService;

    //Dependency Injection here ! - constructor injection
    private AuthController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping("/login")
    public String login (@RequestParam String email, @RequestParam String password) {
        return authService.login(email, password);
    }

    @PostMapping("/register")
    public String login (@RequestParam String email, @RequestParam String name, @RequestParam String password) {
        return authService.register(email, name, password);
    }
}
