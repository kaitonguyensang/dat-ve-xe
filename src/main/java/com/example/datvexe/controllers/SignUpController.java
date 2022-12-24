package com.example.datvexe.controllers;

import com.example.datvexe.common.Role;
import com.example.datvexe.handler.CustomException;
import com.example.datvexe.payloads.requests.SignUpRequest;
import com.example.datvexe.payloads.responses.DataResponse;
import com.example.datvexe.services.SignUpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/signup")
public class SignUpController {

    @Autowired
    SignUpService signUpService;

    @PostMapping("/add")
    public DataResponse addTaiKhoan(@RequestBody SignUpRequest signUpRequest){
        if(signUpRequest == null) throw new CustomException("404", "Missing field!!!");
        if (signUpRequest.getRole() == Role.USER){
            Integer check = signUpService.addTaiKhoanUser(signUpRequest);
            if (check == 1) return new DataResponse("400","Username da ton tai!!");
            if (check == 2) return new DataResponse("400","CMND da ton tai!!");
            if (check == 3) return new DataResponse("400","So dien thoai da ton tai!!");
            if (check == 4) return new DataResponse("400","Email da ton tai!!");
            if (check == 6) return new DataResponse("400","Dang ky khong thanh cong!!!");
            if (check == 5) return new DataResponse("200","Dang ky thanh cong!!!");
        }
        if (signUpRequest.getRole()==Role.NHAXE){
            Integer check = signUpService.addTaiKhoanNhaXe(signUpRequest);
            if (check == 1) return new DataResponse("400","Username da ton tai!!");
            if (check == 2) return new DataResponse("400","CMND da ton tai!!");
            if (check == 3) return new DataResponse("400","So dien thoai da ton tai!!");
            if (check == 4) return new DataResponse("400","Email da ton tai!!");
            if (check == 6) return new DataResponse("400","Dang ky khong thanh cong!!!");
            if (check == 5) return new DataResponse("200","Dang ky thanh cong!!!");
        }
        if (signUpRequest.getRole()==Role.ADMIN){
            Integer check = signUpService.addTaiKhoanAdmin(signUpRequest);
            if (check == 1) return new DataResponse("400","Username da ton tai!!");
            if (check == 2) return new DataResponse("400","CMND da ton tai!!");
            if (check == 3) return new DataResponse("400","So dien thoai da ton tai!!");
            if (check == 4) return new DataResponse("400","Email da ton tai!!");
            if (check == 6) return new DataResponse("400","Dang ky khong thanh cong!!!");
            if (check == 5) return new DataResponse("200","Dang ky thanh cong!!!");
        }
        return new DataResponse("400","Tao tai khoan khong thanh cong!!!");
    }
}
