package com.example.datvexe.Controllers;

import com.example.datvexe.Handler.CustomException;
import com.example.datvexe.Payloads.Responses.DataResponse;
import com.example.datvexe.Services.VeXeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/vexe")
public class VeXeController {

    @Autowired
    VeXeService veXeService;

    @GetMapping("/user-id/{id}")
    public DataResponse getAllVexXeByUserId(@PathVariable("id") Long id){
        if(id == null) throw new CustomException("404","Khong ton tai user.");
        return new DataResponse("200",veXeService.getAllVeXeByUserId(id));
    }
}
