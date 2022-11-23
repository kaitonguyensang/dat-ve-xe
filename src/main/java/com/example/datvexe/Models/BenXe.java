package com.example.datvexe.Models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonIgnoreType;
import com.fasterxml.jackson.annotation.JsonManagedReference;
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

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL,mappedBy ="benXeDi")
    @JsonIgnore
    private List<TuyenXe> tuyenXeDi;

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL,mappedBy ="benXeDen")
    @JsonIgnore
    private List<TuyenXe> tuyenXeDen;
}