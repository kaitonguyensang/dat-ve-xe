package com.example.datvexe.services;

import com.example.datvexe.models.TaiKhoan;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface TaiKhoanService {
    TaiKhoan getTaiKhoanById(Long id);

    List<TaiKhoan> getAll();
}
