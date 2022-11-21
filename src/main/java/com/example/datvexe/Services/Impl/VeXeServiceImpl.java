package com.example.datvexe.Services.Impl;

import com.example.datvexe.Models.User;
import com.example.datvexe.Models.VeXe;
import com.example.datvexe.Repositories.UserRepository;
import com.example.datvexe.Repositories.VeXeRepository;
import com.example.datvexe.Services.VeXeService;
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
        User user = userRepository.getUserById(id);
        if(user == null) return null;
        List<VeXe> veXeList = veRepository.getVeXeByUser(user);
        return veXeList;
    }
}
