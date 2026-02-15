package com.shiftFlow.org.service.implementation;

import com.shiftFlow.org.config.PasswordEncoder;
import com.shiftFlow.org.repository.UserRepository;
import com.shiftFlow.org.service.AuthService;
import com.shiftFlow.org.service.EmailService;
import com.shiftFlow.org.user.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor // This will inject our deps and auto create a constructor for us
public class AuthServiceImpl implements AuthService {

    private final EmailService emailService;
    private final PasswordEncoder passwordEncoder;
    private final UserRepository userRepository;

    //Behind the scenes this what lombok does for us : Dependency Injection
    /**
     * Lombok generates this constructor automatically:
     *
     * public AuthService(UserRepository userRepository,
     *                    PasswordEncoder passwordEncoder,
     *                    EmailService emailService) {
     *     this.userRepository = userRepository;
     *     this.passwordEncoder = passwordEncoder;
     *     this.emailService = emailService;
     * }
     */
    @Override
    public String login(String email, String password) {
        System.out.println("the user is trying to login: " + email);
        Optional<User> optionalUser = userRepository.findByEmail(email);
        if (optionalUser.isEmpty()) {
            return "User Not Found";
        }
        User user = optionalUser.get();
        System.out.println("User found : " + user.getName());
        return "Login Successful for user: " + user.getEmail();
    }

    @Override
    public String register(String email, String name, String password) {
        System.out.println("New user is trying to register: " + email);

        if(userRepository.findByEmail(email).isPresent()) {
            return "Register failed, user already exists";
        }
        String encodedPassword = passwordEncoder.encodePassword(password);
        System.out.println("Password encoded: " + encodedPassword);
        User user = new User(email, name, "developer");
        userRepository.save(user);
        emailService.sendWelcomeEmail(email);
        return "User Registered ! Welcome" + email;
    }
}
