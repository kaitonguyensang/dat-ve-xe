package com.example.datvexe.services.impl;

import com.example.datvexe.config.CustomTaiKhoanDetails;
import com.example.datvexe.models.TaiKhoan;
import com.example.datvexe.payloads.requests.TaiKhoanRequest;
import com.example.datvexe.repositories.TaiKhoanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaiKhoanServiceImpl implements UserDetailsService {

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
        TaiKhoan taiKhoanCheck = taiKhoanRepository.findTaiKhoanById(taiKhoanRequest.getId());
        if(taiKhoanCheck == null) return null;
        TaiKhoan taiKhoanUpdate = convertTaiKhoanRequestToTaiKhoan(taiKhoanRequest, taiKhoanCheck);
        taiKhoanUpdate = taiKhoanRepository.save(taiKhoanUpdate);
        return taiKhoanUpdate;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        TaiKhoan user = taiKhoanRepository.findTaiKhoanByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException(username);
        }
        return new CustomTaiKhoanDetails(user);
    }

    public UserDetails loadUserById(Long id){
        TaiKhoan user = taiKhoanRepository.findTaiKhoanById(id);
        if (user == null) {
            return null;
        }
        return new CustomTaiKhoanDetails(user);
    }
}
