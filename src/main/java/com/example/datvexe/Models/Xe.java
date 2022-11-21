package com.example.datvexe.Models;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Table(name = "xe")
public class Xe {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "biensoxe")
    private String bienSoXe;

    @ManyToOne
    @JoinColumn(name = "nhaxe_id",referencedColumnName = "id")
    private NhaXe nhaXe;

    @ManyToOne
    @JoinColumn(name = "loaixe_id",referencedColumnName = "id")
    private LoaiXe loaiXe;

}
