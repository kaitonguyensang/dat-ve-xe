package com.example.datvexe.controllers;

import com.example.datvexe.handler.CustomException;
import com.example.datvexe.models.BenXe;
import com.example.datvexe.payloads.requests.BenXeRequest;
import com.example.datvexe.payloads.responses.DataResponse;
import com.example.datvexe.services.BenXeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/benxe")
public class BenXeController {

    @Autowired
    BenXeService benXeService;

    @GetMapping("/{id}")
    public DataResponse getBenXeById(@PathVariable("id") String id) {
        if (id == null) throw new CustomException("404", "Missing field");
        Long benXeId = Long.valueOf(id);
        BenXe benXe = benXeService.findBenXeById(benXeId);
        if (benXe == null) throw new CustomException("404", "Khong tim thay ben xe!!!!");
        return new DataResponse("200", benXe);
    }

    @GetMapping("/all")
    public DataResponse getAll() {
        List<BenXe> benXeList = benXeService.findAllBenXe();
        if (benXeList.size() == 0) throw new CustomException("404", "Khong co ben xe!!!");
        return new DataResponse("200", benXeList);
    }

    @PostMapping("/add")
    public DataResponse addNewBenXe(@RequestBody BenXeRequest benXeRequest) {
        if (benXeRequest == null) throw  new CustomException("404", "Missing field");
        return new DataResponse("200", benXeService.addNewBenXe(benXeRequest));
    }

    @PutMapping("/{id}")
    public DataResponse updateBenXe(@PathVariable("id") String id, @RequestBody BenXeRequest benXeRequest) {
        if (benXeRequest == null) throw  new CustomException("404", "Missing field");
        Long benXeId = Long.valueOf(id);
        BenXe benXe = benXeService.updateBenXe(benXeRequest,benXeId);
        if (benXe == null) throw new CustomException("404", "Khong tim thay ben xe!!!");
        return new DataResponse("200", benXe);
    }

    @DeleteMapping("/{id}")
    public DataResponse deleteBenXe(@PathVariable("id") String id) {
        Long benXeId = Long.valueOf(id);
        benXeId = benXeService.deleteBenXe(benXeId);
        if(benXeId == null) throw  new CustomException("404", "Khong tim thay ben xe");
        return new DataResponse("200", "Xoa thanh cong ben xe id: " + benXeId);
    }
}