package com.example.datvexe.Models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "hoten")
    private String hoTen;

    @Column(name ="cmnd")
    private String cmnd;

    @Column(name = "sdt")
    private String sdt;

    @Column(name = "email")
    private String email;

    @Column(name = "diachi")
    private String diaChi;

    @Column(name = "trangthaihoatdong")
    private int trangThaiHoatDong;

    @OneToOne
    @JoinColumn(name = "taikhoan_id",referencedColumnName = "id")
    private TaiKhoan taiKhoan;

    @OneToMany(mappedBy ="user")
    private List<DanhGia> danhGia;

    @OneToMany(mappedBy ="user")
    private List<VeXe> veXe;

    @OneToMany(mappedBy ="user")
    private List<HangHoa> hangHoa;
}
