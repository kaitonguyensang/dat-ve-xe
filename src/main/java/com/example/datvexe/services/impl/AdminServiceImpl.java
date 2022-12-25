package com.example.datvexe.services.impl;

import com.example.datvexe.models.Admin;
import com.example.datvexe.models.TaiKhoan;
import com.example.datvexe.payloads.requests.AdminRequest;
import com.example.datvexe.payloads.requests.SignUpRequest;
import com.example.datvexe.payloads.responses.DataResponse;
import com.example.datvexe.repositories.AdminRepository;
import com.example.datvexe.repositories.TaiKhoanRepository;
import com.example.datvexe.services.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminServiceImpl implements AdminService {

    @Autowired
    AdminRepository adminRepository;

    @Autowired
    TaiKhoanRepository taiKhoanRepository;

    @Autowired
    CommonServiceImpl commonService;

    public TaiKhoan convertAdminRequestToTaiKhoan(AdminRequest adminRequest){
        TaiKhoan taiKhoan = taiKhoanRepository.findTaiKhoanByAdmin_Id(adminRequest.getId());
        if (taiKhoan == null) return null;
        taiKhoan.setUsername(adminRequest.getUsername());
        taiKhoan.setPassword(adminRequest.getPassword());
        taiKhoan.setRole(adminRequest.getRole());
        taiKhoan.setTrangThaiHoatDong(adminRequest.getTrangThaiHoatDong());
        return taiKhoan;
    }

    public Admin convertAdminRequestToAdmin(AdminRequest adminRequest, Admin admin, TaiKhoan taiKhoan){
        admin.setName(adminRequest.getName());
        admin.setSdt(adminRequest.getSdt());
        admin.setCmnd(adminRequest.getCmnd());
        admin.setTaiKhoan(taiKhoan);
        return admin;
    }

    public SignUpRequest convertAdminRequestToSignUpRequest(AdminRequest adminRequest){
        SignUpRequest signUpRequest = new SignUpRequest();
        signUpRequest.setName(adminRequest.getName());
        signUpRequest.setCmnd(adminRequest.getCmnd());
        signUpRequest.setSdt(adminRequest.getSdt());
        signUpRequest.setEmail(adminRequest.getEmail());
        signUpRequest.setUsername(adminRequest.getUsername());
        signUpRequest.setPassword(adminRequest.getPassword());
        signUpRequest.setTrangThaiHoatDong(adminRequest.getTrangThaiHoatDong());
        signUpRequest.setRole(adminRequest.getRole());
        return signUpRequest;
    }

    public List<Admin> getAll(){
        List<Admin> listAdmin = adminRepository.findAll();
        if (listAdmin.size() == 0) return null;
        return listAdmin;
    }

    @Override
    public DataResponse updateAdmin(AdminRequest adminRequest) {
        Admin admin = adminRepository.findAdminById(adminRequest.getId());
        if (admin == null) return new DataResponse("1","/");
        TaiKhoan taiKhoanNew = convertAdminRequestToTaiKhoan(adminRequest);
        if (taiKhoanNew == null) return new DataResponse("2","/");
        Admin adminNew = convertAdminRequestToAdmin(adminRequest, admin, taiKhoanNew);
        int check = commonService.checkInForUpdateAccount(convertAdminRequestToSignUpRequest(adminRequest),taiKhoanNew);
        if (check != 5) return new DataResponse(String.valueOf(check+2),"/");
        taiKhoanRepository.save(taiKhoanNew);
        Admin adminUpdate= adminRepository.save(adminNew);
        return new DataResponse("200",adminUpdate);
    }

    @Override
    public Admin getAdminById(Long id) {
        Admin admin = adminRepository.findAdminById(id);
        if (admin == null) return null;
        return admin;
    }


}
