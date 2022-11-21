package com.example.datvexe.Services;

import com.example.datvexe.Models.VeXe;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface VeXeService {
    List<VeXe> getAllVeXeByUserId(Long userId);
}
