package com.example.datvexe.services;

import com.example.datvexe.payloads.responses.SaoTrungBinhAllResponse;
import com.example.datvexe.payloads.requests.ThongKeAdminRequest;
import com.example.datvexe.payloads.responses.ThongKeAdminDoanhThuResponse;
import com.example.datvexe.payloads.responses.ThongKeAdminUseResponse;
import com.example.datvexe.payloads.responses.ThongKeSaoResponse;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.List;

@Component
public interface ThongKeService {
    float tinhTrungBinhSao(Long nhaXeId);

    ThongKeSaoResponse thongKeSaoRequest(Long nhaXeId);

    List<SaoTrungBinhAllResponse> getSaoTrungBinhAll();

    List<ThongKeAdminUseResponse> getThongKeAdminUse(ThongKeAdminRequest request);

    List<ThongKeAdminDoanhThuResponse> getThongKeAdminDoanhThu(ThongKeAdminRequest request);
}
