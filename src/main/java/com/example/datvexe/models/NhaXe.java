package com.example.datvexe.models;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "nhaxe")
public class NhaXe {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "tennhaxe")
    private String tenNhaXe;

    @Column(name = "sdt")
    private String sdt;

    @Column(name = "motangan")
    private String moTaNgan;

    @Column(name = "diachi")
    private String diaChi;


    @OneToOne
    @JoinColumn(name = "taikhoan_id",referencedColumnName = "id")
    private TaiKhoan taiKhoan;

    @OneToMany(mappedBy ="nhaXe")
    private List<Xe> xe;

    @OneToMany(mappedBy ="nhaXe")
    private List<DanhGia> danhGia;
}