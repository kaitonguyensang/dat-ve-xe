package com.example.datvexe.controllers;


import com.example.datvexe.handler.CustomException;
import com.example.datvexe.models.DanhGia;
import com.example.datvexe.payloads.requests.DanhGiaRequest;
import com.example.datvexe.payloads.responses.DataResponse;
import com.example.datvexe.services.DanhGiaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("api/danhgia")
public class DanhGiaController {

    @Autowired
    DanhGiaService danhGiaService;

    @PostMapping("/add")
    public DataResponse addDanhGia(@RequestBody DanhGiaRequest danhGiaRequest){
        if (danhGiaRequest == null) throw new CustomException("400", "Missing request!!!");
        DanhGia dataResponse = danhGiaService.addDanhGia(danhGiaRequest);
        if (dataResponse == null) throw new CustomException("404", "Them danh gia that bai!!!");
        return new DataResponse("200",dataResponse);
    }

    @GetMapping("/{id}")
    public DataResponse getDanhGiaById(@PathVariable("id") String id){
        if (id ==null) throw  new CustomException("400", "Missing field!!!");
        Long danhGiaId = Long.valueOf(id);
        DanhGia danhGia = danhGiaService.getDanhGiaById(danhGiaId);
        if (danhGia == null) throw new CustomException("404", "Khong tim thay danh gia!!!");
        return new DataResponse("200",danhGia);
    }

    @GetMapping("/nhaxe/{nhaxe_id}")
    public DataResponse getDanhGiaByNhaXeId(@PathVariable("nhaxe_id") String nhaXeId){
        if (nhaXeId ==null) throw  new CustomException("400", "Missing field!!!");
        Long id = Long.valueOf(nhaXeId);
        List<DanhGia> danhGia = danhGiaService.getDanhGiaByNhaXeId(id);
        if (danhGia == null) throw new CustomException("200", "Khong co danh gia nao!!!");
        return new DataResponse("200",danhGia);
    }

}
