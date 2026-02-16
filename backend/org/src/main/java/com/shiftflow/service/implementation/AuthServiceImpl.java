package com.shiftflow.service.implementation;

import com.shiftflow.config.PasswordEncoder;
import com.shiftflow.exception.EmailAlreadyExistsException;
import com.shiftflow.mappers.UserMapper;
import com.shiftflow.repository.UserRepository;
import com.shiftflow.service.AuthService;
import com.shiftflow.service.EmailService;
import com.shiftflow.user.dtos.request.UserRegistrationRequest;
import com.shiftflow.user.dtos.response.UserResponse;
import com.shiftflow.user.models.Role;
import com.shiftflow.user.models.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor // This will inject our deps and auto create a constructor for us
public class AuthServiceImpl implements AuthService {

    private final EmailService emailService;
    private final PasswordEncoder passwordEncoder;
    private final UserRepository userRepository;
    private final UserMapper userMapper;

    @Override
    public String login(String email, String password) {
        System.out.println("the user is trying to login: " + email);
        Optional<User> optionalUser = userRepository.findByEmail(email);
        if (optionalUser.isEmpty()) {
            return "User Not Found";
        }
        User user = optionalUser.get();
        System.out.println("User found : " + user.getFirstName());
        return "Login Successful for user: " + user.getEmail();
    }

    @Override
    public UserResponse register(UserRegistrationRequest registrationRequest) {
        System.out.println("New user is trying to register: " + registrationRequest.getEmail());
        if(userRepository.findByEmail(registrationRequest.getEmail()).isPresent()) {
            throw new EmailAlreadyExistsException("Register failed, user already exists");
        }
        String encodedPassword = passwordEncoder.encodePassword(registrationRequest.getPassword());
        User user = userMapper.toEntityFromReq(registrationRequest);
        user.setPassword(encodedPassword);
        userRepository.save(user);
        return userMapper.toDto(user);
    }
}
