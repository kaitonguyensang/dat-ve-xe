package com.example.datvexe.services;

import com.example.datvexe.models.NhaXe;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface NhaXeService {
    List<NhaXe> getAll();
}
