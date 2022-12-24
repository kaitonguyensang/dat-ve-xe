package com.example.datvexe.controllers;

import com.example.datvexe.handler.CustomException;
import com.example.datvexe.models.NhaXe;
import com.example.datvexe.payloads.responses.DataResponse;
import com.example.datvexe.services.NhaXeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/nhaxe")
public class NhaXeController {

    @Autowired
    NhaXeService nhaXeService;

    @GetMapping("/all")
    public DataResponse getAll(){
        List<NhaXe> listNhaXe = nhaXeService.getAll();
        if (listNhaXe.size() == 0) throw new CustomException("400","Khong co nha xe nao!!!");
        return new DataResponse("200",listNhaXe);
    }
}
