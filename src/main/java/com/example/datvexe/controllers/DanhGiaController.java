package com.example.datvexe.controllers;


import com.example.datvexe.payloads.requests.DanhGiaRequest;
import com.example.datvexe.payloads.responses.DataResponse;
import com.example.datvexe.services.DanhGiaService;
import com.example.datvexe.services.impl.DanhGiaServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("api/danhgia")
public class DanhGiaController {

    @Autowired
    DanhGiaServiceImpl danhGiaService;

    @PostMapping("/add")
    public DataResponse addDanhGia(@RequestBody DanhGiaRequest dataRequest){
        return null;
    }
}
