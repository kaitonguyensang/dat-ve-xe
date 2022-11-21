package com.example.datvexe.Models;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Table(name = "hanghoa")
public class HangHoa {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "cannang")
    private Long canNang;

    @Column(name = "gia")
    private int gia;

    @Column(name = "tennguoinhan")
    private String tenNguoNhan;

    @Column(name = "sdtnguoinhan")
    private String sdtNguoiNhan;

    @Column(name = "email")
    private String email;

    @Column(name = "trangthai")
    private int trangThai;

    @ManyToOne
    @JoinColumn(name = "tuyenxe_id",referencedColumnName = "id")
    private TuyenXe tuyenXe;

    @ManyToOne
    @JoinColumn(name = "user_id",referencedColumnName = "id")
    private User user;
}
