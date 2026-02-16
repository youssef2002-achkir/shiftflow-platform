package com.shiftflow.service.implementation;

import com.shiftflow.service.EmailService;
import org.springframework.stereotype.Service;

@Service
public class EmailServiceImpl implements EmailService {

    @Override
    public void sendWelcomeEmail(String email) {
        System.out.println("Welcome to our platform dear: " + email);
    }

    @Override
    public void sendResetPasswordEmail(String email) {
        System.out.println("Dear " + email);
        System.out.println("Here is the link to reset your password");
    }
}
