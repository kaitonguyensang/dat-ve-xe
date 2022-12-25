package com.example.datvexe.payloads.requests;

import com.example.datvexe.common.Role;
import com.example.datvexe.common.TrangThai;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@Data
@Getter
@Setter
public class TaiKhoanRequest {
    @Enumerated(EnumType.STRING)
    private Role role;

    private Long id;
    private String username;
    private String password;
    @Enumerated(EnumType.STRING)
    private TrangThai trangThaiHoatDong;
}