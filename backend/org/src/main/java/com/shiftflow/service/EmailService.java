package com.shiftflow.service;

import org.springframework.stereotype.Service;

@Service
public interface EmailService {
    void sendWelcomeEmail(String email);
    void sendResetPasswordEmail(String email);
}
