package com.example.datvexe.controllers;

import com.example.datvexe.handler.CustomException;
import com.example.datvexe.payloads.responses.DataResponse;
import com.example.datvexe.payloads.responses.ThongKeSaoRequest;
import com.example.datvexe.services.ThongKeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.persistence.Access;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("api/thongke")
public class ThongKeController {

    @Autowired
    ThongKeService thongKeService;

    @GetMapping("/nhaxe/sao-trung-binh/{nhaxeid}")
    public DataResponse getSaoTrungBinh(@PathVariable("nhaxeid") String nhaxeid){
        if (nhaxeid == null) throw new CustomException("400","Missing field!!!");
        Long id =Long.valueOf(nhaxeid);
        float trungBinhSao = thongKeService.tinhTrungBinhSao(id);
        return new DataResponse("200",trungBinhSao);
    }

    @GetMapping("/nhaxe/so-sao/{nhaxeid}")
    public DataResponse getSoSao(@PathVariable("nhaxeid") String nhaxeid){
        if (nhaxeid == null) throw new CustomException("400","Missing field!!!");
        Long id =Long.valueOf(nhaxeid);
        ThongKeSaoRequest thongKeSao = thongKeService.thongKeSaoRequest(id);
        return new DataResponse("200",thongKeSao);
    }

}
