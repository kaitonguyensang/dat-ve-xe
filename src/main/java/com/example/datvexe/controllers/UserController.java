package com.example.datvexe.controllers;

import com.example.datvexe.handler.CustomException;
import com.example.datvexe.models.Admin;
import com.example.datvexe.models.User;
import com.example.datvexe.payloads.responses.DataResponse;
import com.example.datvexe.services.AdminService;
import com.example.datvexe.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/user")
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping("/all")
    public DataResponse getAll(){
        List<User> listUser = userService.getAll();
        if (listUser==null) throw new CustomException("400","Khong co Admin nao ca!!!");
        return new DataResponse("200",listUser);
    }
}
