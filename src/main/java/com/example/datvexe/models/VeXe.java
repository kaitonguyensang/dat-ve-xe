package com.example.datvexe.models;

import com.example.datvexe.common.HinhThucThanhToan;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
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
    private LocalDate ngayDat;

    @Column(name = "ngaynhan")
    private LocalDate ngayNhan;

    @ManyToOne
    @JoinColumn(name = "tuyenxe_id",referencedColumnName = "id")
    @JsonIgnore
    private TuyenXe tuyenXe;

    @ManyToOne
    @JoinColumn(name = "user_id",referencedColumnName = "id")
    @JsonIgnore
    private User user;

    @Enumerated
    private HinhThucThanhToan hinhThucThanhToan;

}
