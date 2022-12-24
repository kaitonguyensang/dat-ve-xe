package com.example.datvexe.services;

import com.example.datvexe.models.TaiKhoan;
import com.example.datvexe.payloads.requests.TaiKhoanRequest;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface TaiKhoanService {
    TaiKhoan getTaiKhoanById(Long id);
    List<TaiKhoan> getAll();
    TaiKhoan updateTaiKhoan(TaiKhoanRequest taiKhoanRequest);
}
