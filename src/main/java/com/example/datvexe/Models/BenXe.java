package com.example.datvexe.Models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "benxe")
public class BenXe {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "tenbenxe")
    private String tenBenXe;

    @Column(name = "diachi")
    private String diaChi;

    @OneToMany(mappedBy ="benXeDi")

    private List<TuyenXe> tuyenXeDi;

    @OneToMany(mappedBy ="benXeDen")
    private List<TuyenXe> tuyenXeDen;
}