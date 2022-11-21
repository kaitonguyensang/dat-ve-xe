package com.example.datvexe.Payloads.Requests;

import com.example.datvexe.Models.BenXe;
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
    private int trangThai;
    private Long benXeDi;
    private Long benXeDen;
}
