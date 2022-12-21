package com.example.datvexe.services;

import com.example.datvexe.models.User;
import org.springframework.stereotype.Component;

@Component
public interface UserService {
    User getUserById(Long userId);
}
