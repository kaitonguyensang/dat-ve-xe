package com.example.datvexe.controllers;

import com.example.datvexe.payloads.requests.HangHoaRequest;
import com.example.datvexe.payloads.responses.DataResponse;
import com.example.datvexe.services.HangHoaService;
import com.example.datvexe.services.impl.HangHoaServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/api/hanghoa")
public class HangHoaController {

    @Autowired
    HangHoaServiceImpl hangHoaService;

    @PostMapping("/add")
    public DataResponse addHangHoa(@RequestBody HangHoaRequest hangHoaRequest){
        return null;
    }
}
