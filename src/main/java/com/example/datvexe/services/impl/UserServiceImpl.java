package com.example.datvexe.services.impl;

import com.example.datvexe.models.User;
import com.example.datvexe.payloads.responses.DataResponse;
import com.example.datvexe.repositories.UserRepository;
import com.example.datvexe.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    public User getUserById(Long id){
        User user = userRepository.findUserById(id);
        if (user ==null) return null;
        return user;
    }

    @Override
    public List<User> getAll() {
        List<User> listUser = userRepository.findAll();
        if (listUser.size() == 0) return null;
        return listUser;
    }
}
