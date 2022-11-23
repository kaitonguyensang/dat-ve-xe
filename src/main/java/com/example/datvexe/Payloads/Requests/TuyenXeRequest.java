package com.example.datvexe.Payloads.Requests;

import com.example.datvexe.Models.BenXe;
import com.example.datvexe.common.TrangThai;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Data
@Setter
@Getter
public class TuyenXeRequest {
    private Date thoiGianKhoiHanh;
    private Date ngayDen;
    private int giaVe;
    private TrangThai trangThai;
    private Long benXeDi;
    private Long benXeDen;
}
