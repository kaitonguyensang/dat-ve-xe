package com.example.datvexe.services;

import com.example.datvexe.payloads.responses.ThongKeSaoRequest;
import org.springframework.stereotype.Component;

@Component
public interface ThongKeService {
    float tinhTrungBinhSao(Long nhaXeId);

    ThongKeSaoRequest thongKeSaoRequest(Long nhaXeId);
}
