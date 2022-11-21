package com.example.datvexe.Payloads.Requests;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Setter
@Getter
public class BenXeRequest {
    private String tenBenXe;
    private String diaChi;
}