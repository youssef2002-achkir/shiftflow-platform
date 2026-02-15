package com.shiftFlow.org.service;

import org.springframework.stereotype.Service;

@Service
public interface AuthService {
    String login (String email, String password);
    String register (String email,String name, String password);
}
