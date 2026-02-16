package com.shiftflow.controller;

import com.shiftflow.service.AuthService;
import com.shiftflow.user.dtos.request.UserRegistrationRequest;
import com.shiftflow.user.dtos.response.UserResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
    public ResponseEntity<UserResponse> login (@RequestBody UserRegistrationRequest request) {
        UserResponse savedUser = authService.register(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedUser);
    }
}
