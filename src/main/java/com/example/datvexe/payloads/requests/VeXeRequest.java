package com.example.datvexe.payloads.requests;

import com.example.datvexe.common.HinhThucThanhToan;
import com.example.datvexe.common.TrangThai;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@Data
public class VeXeRequest {
    private int soGhe;
    private LocalDate ngayDat;
    private LocalDate ngayNhan;
    private HinhThucThanhToan hinhThucThanhToan;
    private Long tuyenXeId;
    private Long UserId;
    private TrangThai trangThai;
}
