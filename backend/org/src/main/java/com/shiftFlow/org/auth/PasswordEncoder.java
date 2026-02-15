package com.shiftFlow.org.auth;

import org.springframework.stereotype.Component;

@Component
public class PasswordEncoder {

    private String encodePassword(String password) {
        return "encoded_" + password;
    }

    private boolean matches (String password, String encodedPassword) {
        return encodedPassword.equals(encodePassword(password));
    }
}
