package com.example.datvexe.services.impl;

import com.example.datvexe.models.User;
import com.example.datvexe.models.VeXe;
import com.example.datvexe.repositories.UserRepository;
import com.example.datvexe.repositories.VeXeRepository;
import com.example.datvexe.services.VeXeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VeXeServiceImpl implements VeXeService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    VeXeRepository veRepository;

    public List<VeXe> getAllVeXeByUserId(Long id){
        User user = userRepository.findUserById(id);
        if(user == null) return null;
        List<VeXe> veXeList = veRepository.getVeXeByUser(user);
        return veXeList;
    }
}
