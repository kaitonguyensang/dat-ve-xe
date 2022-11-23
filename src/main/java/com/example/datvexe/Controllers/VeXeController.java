package com.example.datvexe.Controllers;

import com.example.datvexe.Handler.CustomException;
import com.example.datvexe.Models.VeXe;
import com.example.datvexe.Payloads.Responses.DataResponse;
import com.example.datvexe.Services.VeXeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/vexe")
public class VeXeController {

    @Autowired
    VeXeService veXeService;

    @GetMapping("/user-id/{id}")
    public DataResponse getAllVexXeByUserId(@PathVariable("id") Long id){
        if(id == null) throw new CustomException("404","Khong ton tai user!!!!");
        List<VeXe> vexe = veXeService.getAllVeXeByUserId(id);
        if (vexe == null) throw new CustomException("400", "Khong ton tai user!!!");
        if (vexe.size() == 0) return new DataResponse("200", "Chua dat ve!!!");
        return new DataResponse("200",vexe);
    }
}
