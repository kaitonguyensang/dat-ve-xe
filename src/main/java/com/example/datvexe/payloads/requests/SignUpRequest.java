package com.example.datvexe.payloads.requests;


import com.example.datvexe.common.Role;
import lombok.Getter;
import lombok.Setter;
import org.springframework.web.bind.annotation.RequestBody;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@Getter
@Setter
public class SignUpRequest {
    @Enumerated(EnumType.STRING)
    private Role role;


    private String username;
    private String password;
    private String name;
    private String hoTen;
    private String tenNhaXe;
    private String sdt;
    private String cmnd;
    private String email;
    private String diaChi;
    private String moTaNgan;
}
