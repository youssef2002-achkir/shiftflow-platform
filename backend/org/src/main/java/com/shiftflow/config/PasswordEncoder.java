package com.shiftflow.config;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class PasswordEncoder {
    BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(16);


    public String encodePassword(String password) {
        return encoder.encode(password);
    }

    public boolean matches (String password, String encodedPassword) {
        return encoder.matches(password, encodedPassword);
    }
}
