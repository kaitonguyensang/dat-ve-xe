package com.example.datvexe.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Table(name = "admin")
public class Admin {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "cmnd")
    private String cmnd;

    @Column(name = "sdt")
    private String sdt;

    @Column(name = "email")
    private String email;

    @OneToOne
    @JoinColumn(name = "taikhoan_id", referencedColumnName = "id")
    private TaiKhoan taiKhoan;
}