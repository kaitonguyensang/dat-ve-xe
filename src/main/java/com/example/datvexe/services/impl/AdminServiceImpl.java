package com.example.datvexe.services.impl;

import com.example.datvexe.models.Admin;
import com.example.datvexe.repositories.AdminRepository;
import com.example.datvexe.services.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminServiceImpl implements AdminService {

    @Autowired
    AdminRepository adminRepository;

    public List<Admin> getAll(){
        List<Admin> listAdmin = adminRepository.findAll();
        if (listAdmin.size() == 0) return null;
        return listAdmin;
    }


}
