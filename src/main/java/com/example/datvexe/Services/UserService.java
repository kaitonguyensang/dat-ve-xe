package com.example.datvexe.Services;

import com.example.datvexe.Models.User;
import org.springframework.stereotype.Component;

@Component
public interface UserService {
    User getUserById(Long userId);
}
