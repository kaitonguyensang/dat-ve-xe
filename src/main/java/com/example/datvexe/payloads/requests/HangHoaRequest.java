package com.example.datvexe.payloads.requests;

import com.example.datvexe.common.TrangThai;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Data
public class HangHoaRequest {
    private Long canNang;
    private int gia;
    private String tenNguoiNhan;
    private String sdtNguoiNhan;
    private String email;
    private Long tuyenXeId;
    private Long useId;
}
