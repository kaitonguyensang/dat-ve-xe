package com.example.datvexe.Models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity
@Getter
@Setter
@Table(name ="vexe")
public class VeXe {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "soghe")
    private int soGhe;

    @Column(name = "ngaydat")
    private Date ngayDat;

    @Column(name = "ngaynhan")
    private Date ngayNhan;

    @OneToOne
    @JoinColumn(name = "tuyenxe_id",referencedColumnName = "id")
    private TuyenXe tuyenXe;

    @ManyToOne
    @JoinColumn(name = "user_id",referencedColumnName = "id")
    private User user;

    @OneToOne(mappedBy ="veXe")
    private HinhThucThanhToan hinhThucThanhToan;

}
