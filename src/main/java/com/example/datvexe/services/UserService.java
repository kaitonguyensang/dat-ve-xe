package com.example.datvexe.services;

import com.example.datvexe.models.User;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface UserService {
    User getUserById(Long userId);
    List<User> getAll();
}
