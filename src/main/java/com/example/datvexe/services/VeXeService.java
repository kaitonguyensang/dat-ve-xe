package com.example.datvexe.services;

import com.example.datvexe.models.VeXe;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface VeXeService {
    List<VeXe> getAllVeXeByUserId(Long userId);
}
