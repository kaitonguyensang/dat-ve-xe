package com.example.datvexe.Models;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Getter
@Setter
@Table(name ="tuyenxe")
public class TuyenXe {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "thoigiankhoihanh")
    @JsonFormat(pattern="yyyy-MM-dd'T'HH:mm:ss")
    private Date thoiGianKhoiHanh;

    @Column(name = "ngayden")
    @JsonFormat(pattern="yyyy-MM-dd'T'HH:mm:ss")
    private Date ngayDen;

    @Column(name = "giave")
    private int giaVe;

    @Column(name = "trangthai")
    private int trangThai;

    @ManyToOne
    @JoinColumn(name = "benxedi_id", referencedColumnName = "id")
    private BenXe benXeDi;
    @ManyToOne
    @JoinColumn(name = "benxeden_id", referencedColumnName = "id")
    private BenXe benXeDen;

    @OneToOne(mappedBy="tuyenXe")
    private VeXe veXe;

    @OneToMany(mappedBy="tuyenXe")
    private List<HangHoa> hangHoa;

}
