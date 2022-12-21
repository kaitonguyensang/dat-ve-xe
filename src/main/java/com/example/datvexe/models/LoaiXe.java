package com.example.datvexe.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "loaixe")
public class LoaiXe {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "tenloaixe")
    private String tenLoaiXe;

    @Column(name="succhua")
    private Integer sucChua;

    @OneToMany(mappedBy ="loaiXe")
    private List<Xe> xe;
}
