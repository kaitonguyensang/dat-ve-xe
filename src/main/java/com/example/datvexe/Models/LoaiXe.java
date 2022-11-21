package com.example.datvexe.Models;
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
    private Long Id;

    @Column(name = "loaixe")
    private String  loaiXe;

    @Column(name = "succhua")
    private int sucChua;

    @OneToMany(mappedBy ="loaiXe")
    private List<Xe> xe;
}
