package com.example.datvexe.Services.Impl;

import com.example.datvexe.Models.User;
import com.example.datvexe.Repositories.UserRepository;
import com.example.datvexe.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    public User getUserById(Long id){
        User user = userRepository.getUserById(id);
        if (user ==null) return null;
        return user;
    }
}
