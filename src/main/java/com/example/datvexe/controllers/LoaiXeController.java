package com.example.datvexe.controllers;

import com.example.datvexe.handler.CustomException;
import com.example.datvexe.models.LoaiXe;
import com.example.datvexe.payloads.requests.LoaiXeRequest;
import com.example.datvexe.payloads.responses.DataResponse;
import com.example.datvexe.services.LoaiXeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/loaixe")
public class LoaiXeController {

    @Autowired
    LoaiXeService loaiXeService;

    @GetMapping("/all")
    public DataResponse getAll(){
        List<LoaiXe> loaiXeList;
        loaiXeList = loaiXeService.getAllLoaiXe();
        if(loaiXeList==null) throw new CustomException("400", "Khong co loai xe nao!!!");
        return new DataResponse("200", loaiXeList);
    }

    @GetMapping("/{id}")
    public DataResponse getById(@PathVariable("id") String id){
        if (id==null) throw new CustomException("400","Missing field!!");
        Long loaXeId = Long.valueOf(id);
        LoaiXe loaiXe = loaiXeService.getLoaiXeById(loaXeId);
        if (loaiXe==null) throw new CustomException("400","Khong co loai xe nao theo yeu cau!!!");
        return new DataResponse("200",loaiXe);
    }

    @PostMapping("/add")
    public DataResponse addLoaiXe(@RequestBody LoaiXeRequest loaiXeRequest){
        if (loaiXeRequest == null) throw new CustomException("400","Missing request!!!");
        LoaiXe loaiXeNew = loaiXeService.addLoaiXe(loaiXeRequest);
        if (loaiXeNew == null) throw new CustomException("404", "Ten loai xe da ton tai!!!");
        return new DataResponse("200",loaiXeNew);
    }
}
