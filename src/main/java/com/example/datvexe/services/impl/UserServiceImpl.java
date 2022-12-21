package com.example.datvexe.services.impl;

import com.example.datvexe.models.User;
import com.example.datvexe.repositories.UserRepository;
import com.example.datvexe.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    public User getUserById(Long id){
        User user = userRepository.findUserById(id);
        if (user ==null) return null;
        return user;
    }
}
