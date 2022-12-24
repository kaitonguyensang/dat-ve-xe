package com.example.datvexe.services;

import com.example.datvexe.models.Admin;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface AdminService {

    public List<Admin> getAll();
}
