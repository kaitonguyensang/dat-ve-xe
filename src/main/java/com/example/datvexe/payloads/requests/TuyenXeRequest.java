package com.example.datvexe.payloads.requests;

import com.example.datvexe.common.TrangThai;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;

@Data
@Setter
@Getter
public class TuyenXeRequest {
    private LocalDate ngayDi;
    private LocalTime gioDi;
    private String thoiGianHanhTrinh;
    private int giaVe;
    private TrangThai trangThai;
    private Long benXeDi;
    private Long benXeDen;
}
