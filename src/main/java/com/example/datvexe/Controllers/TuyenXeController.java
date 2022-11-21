package com.example.datvexe.Controllers;

import com.example.datvexe.Handler.CustomException;
import com.example.datvexe.Models.TuyenXe;
import com.example.datvexe.Payloads.Requests.TuyenXeRequest;
import com.example.datvexe.Payloads.Responses.DataResponse;
import com.example.datvexe.Services.TuyenXeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/tuyenxe")
public class TuyenXeController {
    @Autowired
    TuyenXeService tuyenXeService;

    @GetMapping("/{id}")
    public DataResponse addNewTuyenXe(@PathVariable("id") String id){
        if(id==null||id =="") throw new CustomException("404","Missing Field");
        Long tuyenXeId = Long.valueOf(id);
        TuyenXe tuyenXe = tuyenXeService.findOneById(tuyenXeId);
        if(tuyenXe==null) return new DataResponse("400","Khong tim duoc tuyen xe!!!");
        return new DataResponse("200", tuyenXe);
    }

    @GetMapping("/all")
    public DataResponse getAll(){
        List<TuyenXe> tuyenXeList = tuyenXeService.getAllBenXe();
        if(tuyenXeList.size()==0) throw new CustomException("400","Khong co tuyen xe nao!!!");
        return new DataResponse("200",tuyenXeList);
    }


    @GetMapping("/")
    public DataResponse getTuyenXeByBenXeDiBenXeDenNgayDi(@RequestBody TuyenXeRequest tuyenXeRequest){
        if(tuyenXeRequest == null)throw new CustomException("400","Missing request!!!");
        List<TuyenXe> tuyenXeList = tuyenXeService.getTuyenXeByBenXeDiBenXeDenNgayDi(tuyenXeRequest);
        if(tuyenXeList == null)throw new CustomException("404", "Khong tim thay tuyen xe");
        return new DataResponse("200",tuyenXeList);
    }

    @PostMapping("/add")
    public DataResponse addNewTuyenXe(@RequestBody TuyenXeRequest tuyenXeRequest){
        if(tuyenXeRequest == null)throw new CustomException("404", "Missing Field");
        return new DataResponse("200", tuyenXeService.addNewTuyenXe(tuyenXeRequest));
    }
}