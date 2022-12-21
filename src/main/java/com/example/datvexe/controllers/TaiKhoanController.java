package com.example.datvexe.controllers;

import com.example.datvexe.handler.CustomException;
import com.example.datvexe.models.TaiKhoan;
import com.example.datvexe.payloads.responses.DataResponse;
import com.example.datvexe.services.TaiKhoanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/taikhoan")
public class TaiKhoanController {

    @Autowired
    TaiKhoanService taiKhoanService;

    @GetMapping("/{id}")
    public DataResponse getTaiKhoanById(@PathVariable("id") String id) {
        if (id == null) throw new CustomException("404","Missing id!!");
        Long taiKhoanId = Long.valueOf(id);
        TaiKhoan taiKhoan = taiKhoanService.getTaiKhoanById(taiKhoanId);
        if (taiKhoan == null) return new DataResponse("400","Khong co tai khoan!!!");
        return new DataResponse("200",taiKhoan);
    }

    @GetMapping("/all")
    public DataResponse getAllTaiKhoan(){
        List<TaiKhoan> listTaiKhoan = taiKhoanService.getAll();
        if (listTaiKhoan == null) return new DataResponse("404","Khong co tai khoan nao!!!");
        return new DataResponse("200",listTaiKhoan);
    }
}
