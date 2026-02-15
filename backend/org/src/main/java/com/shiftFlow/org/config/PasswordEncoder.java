package com.shiftFlow.org.config;

import org.springframework.stereotype.Component;

@Component
public class PasswordEncoder {

    public String encodePassword(String password) {
        return "encoded_" + password;
    }

    public boolean matches (String password, String encodedPassword) {
        return encodedPassword.equals(encodePassword(password));
    }
}
