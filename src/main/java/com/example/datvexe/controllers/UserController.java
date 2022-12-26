package com.example.datvexe.controllers;

import com.example.datvexe.handler.CustomException;
import com.example.datvexe.models.Admin;
import com.example.datvexe.models.NhaXe;
import com.example.datvexe.models.User;
import com.example.datvexe.payloads.responses.DataResponse;
import com.example.datvexe.services.AdminService;
import com.example.datvexe.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/api/user")
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping("/all")
    @PreAuthorize("hasAnyRole('ADMIN')")
    public DataResponse getAll(){
        List<User> listUser = userService.getAll();
        if (listUser==null) throw new CustomException("404","Khong co Admin nao ca!!!");
        return new DataResponse("200",listUser);
    }
    @GetMapping("/{id}")
    @PreAuthorize("hasAnyRole('ADMIN','USER')")
    public DataResponse getById(@PathVariable("id") String id){
        if (id==null) throw new CustomException("400", "Missing field!!!");
        Long userId = Long.valueOf(id);
        User user = userService.getUserById(userId);
        if (user==null) throw new CustomException("404", "Khong ton tai admin nhu yeu cau!!!");
        return new DataResponse("200",user);
    }


}
