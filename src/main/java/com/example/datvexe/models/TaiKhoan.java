package com.example.datvexe.models;

import com.example.datvexe.common.Role;
import com.example.datvexe.common.TrangThai;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Table(name = "taikhoan")
public class TaiKhoan {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "username")
    private String username;

    @Column(name = "password")
    private String password;

    @Column(name = "role")
    @Enumerated(EnumType.STRING)
    private Role role;

    @Column(name = "trangthaihoatdong")
    @Enumerated(EnumType.STRING)
    private TrangThai trangThaiHoatDong;

    @OneToOne(mappedBy ="taiKhoan")
    private Admin admin;

    @OneToOne(mappedBy ="taiKhoan")
    private User user;

    @OneToOne(mappedBy ="taiKhoan")
    private NhaXe nhaXe;
}
