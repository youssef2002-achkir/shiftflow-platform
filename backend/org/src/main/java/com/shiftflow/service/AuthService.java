package com.shiftflow.service;

import com.shiftflow.user.dtos.request.UserRegistrationRequest;
import com.shiftflow.user.dtos.response.UserResponse;
import org.springframework.stereotype.Service;

@Service
public interface AuthService {
    String login (String email, String password);
    UserResponse register (UserRegistrationRequest userRegistrationRequest);
}
