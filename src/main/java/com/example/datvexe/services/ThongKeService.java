package com.example.datvexe.services;

import com.example.datvexe.payloads.responses.SaoTrungBinhAllResponse;
import com.example.datvexe.payloads.responses.ThongKeSaoResponse;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface ThongKeService {
    float tinhTrungBinhSao(Long nhaXeId);

    ThongKeSaoResponse thongKeSaoRequest(Long nhaXeId);

    List<SaoTrungBinhAllResponse> getSaoTrungBinhAll();
}
