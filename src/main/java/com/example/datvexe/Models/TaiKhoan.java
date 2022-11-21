package com.example.datvexe.Models;

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

    @ManyToOne
    @JoinColumn(name = "role_id",referencedColumnName = "id")
    private Role role;

    @OneToOne(mappedBy ="taiKhoan")
    private Admin admin;

    @OneToOne(mappedBy ="taiKhoan")
    private User user;

    @OneToOne(mappedBy ="taiKhoan")
    private NhaXe nhaXe;
}
