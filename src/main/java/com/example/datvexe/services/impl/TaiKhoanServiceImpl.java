package com.example.datvexe.services.impl;

import com.example.datvexe.models.TaiKhoan;
import com.example.datvexe.payloads.requests.TaiKhoanRequest;
import com.example.datvexe.repositories.TaiKhoanRepository;
import com.example.datvexe.services.TaiKhoanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaiKhoanServiceImpl implements TaiKhoanService {

    @Autowired
    TaiKhoanRepository taiKhoanRepository;

    public TaiKhoan convertTaiKhoanRequestToTaiKhoan(TaiKhoanRequest taiKhoanRequest, TaiKhoan taiKhoan){
        taiKhoan.setUsername(taiKhoanRequest.getUsername());
        taiKhoan.setPassword(taiKhoanRequest.getPassword());
        taiKhoan.setTrangThaiHoatDong(taiKhoanRequest.getTrangThaiHoatDong());
        taiKhoan.setRole(taiKhoanRequest.getRole());
        return taiKhoan;
    }

    public TaiKhoan getTaiKhoanById(Long id){
        TaiKhoan taiKhoan = taiKhoanRepository.findTaiKhoanById(id);
        if (taiKhoan == null) return null;
        return taiKhoan;
    }

    public List<TaiKhoan> getAll(){
        List<TaiKhoan> listTaiKhoan = taiKhoanRepository.findAll();
        if (listTaiKhoan.size() == 0) return null;
        return listTaiKhoan;
    }

    public TaiKhoan updateTaiKhoan(TaiKhoanRequest taiKhoanRequest){
        TaiKhoan taiKhoanCheck = taiKhoanRepository.findTaiKhoanByUsername(taiKhoanRequest.getUsername());
        if(taiKhoanCheck == null) return null;
        TaiKhoan taiKhoanUpdate = convertTaiKhoanRequestToTaiKhoan(taiKhoanRequest, taiKhoanCheck);
        taiKhoanUpdate = taiKhoanRepository.save(taiKhoanUpdate);
        return taiKhoanUpdate;
    }
}
