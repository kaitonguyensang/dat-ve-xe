package com.example.datvexe.controllers;

import com.example.datvexe.handler.CustomException;
import com.example.datvexe.models.VeXe;
import com.example.datvexe.payloads.requests.VeXeRequest;
import com.example.datvexe.payloads.responses.DataResponse;
import com.example.datvexe.services.VeXeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/api/vexe")
public class VeXeController {

    @Autowired
    VeXeService veXeService;

    @GetMapping("/user-id/{id}")
    public DataResponse getAllVexXeByUserId(@PathVariable("id") Long id){
        if(id == null) throw new CustomException("400","Khong ton tai user!!!!");
        List<VeXe> vexe = veXeService.getAllVeXeByUserId(id);
        if (vexe == null) throw new CustomException("404", "Khong ton tai user!!!");
        if (vexe.size() == 0) return new DataResponse("200", "Chua dat ve!!!");
        return new DataResponse("200",vexe);
    }

    @PostMapping("/add")
    public DataResponse addVeXe(@RequestBody VeXeRequest veXeRequest){
        if (veXeRequest == null) throw new CustomException("400","Missing field!!!");
        DataResponse dataResponse = veXeService.addVeXe(veXeRequest);
        if (dataResponse.getStatus()=="1") throw new CustomException("400", "Khong ton tai tuyen xe!!!");
        if (dataResponse.getStatus()=="2") throw new CustomException("400", "Ghe da duoc dat!!!");
        if (dataResponse.getStatus()=="3") throw new CustomException("400", "Dang ky khong thanh cong!!!");
        if (dataResponse.getStatus()=="4") return new DataResponse("200", dataResponse.getObject());
        return new DataResponse("200", dataResponse.getObject());
    }
}
