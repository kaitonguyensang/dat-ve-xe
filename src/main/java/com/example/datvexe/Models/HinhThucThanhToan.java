package com.example.datvexe.Models;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Table(name = "hinhthucthanhtoan")
public class HinhThucThanhToan {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "tenhinhthucthanhtoan")
    private String tenHinhThucThanhToan;

    @OneToOne
    @JoinColumn(name = "vexe_id", referencedColumnName="id")
    private VeXe veXe;
}