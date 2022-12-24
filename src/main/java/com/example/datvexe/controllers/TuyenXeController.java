package com.example.datvexe.controllers;

import com.example.datvexe.handler.CustomException;
import com.example.datvexe.models.TuyenXe;
import com.example.datvexe.payloads.requests.TuyenXeRequest;
import com.example.datvexe.payloads.requests.TuyenXeRequestByAddress;
import com.example.datvexe.payloads.responses.DataResponse;
import com.example.datvexe.services.TuyenXeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/tuyenxe")
public class TuyenXeController {
    @Autowired
    TuyenXeService tuyenXeService;

    @GetMapping("/{id}")
    public DataResponse addNewTuyenXe(@PathVariable("id") String id){
        if(id==null) throw new CustomException("404","Missing Field");
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


    @GetMapping("/find")
    public DataResponse getTuyenXeByBenXeDiBenXeDenNgayDi(@RequestBody TuyenXeRequest tuyenXeRequest){
        if(tuyenXeRequest == null)throw new CustomException("400","Missing request!!!");
        List<TuyenXe> tuyenXeList = tuyenXeService.getTuyenXeByBenXeDiBenXeDenNgayDi(tuyenXeRequest);
        if(tuyenXeList == null)throw new CustomException("404", "Khong tim thay tuyen xe");
        return new DataResponse("200",tuyenXeList);
    }

    @GetMapping("find-by-address")
    public DataResponse findByAddress(@RequestBody TuyenXeRequestByAddress request){
        if (request == null) throw new CustomException("400","Missing request!!!");
        List<TuyenXe> tuyenXeList =tuyenXeService.getTuyenXeByBenXeDiBenXeDen(request);
        if (tuyenXeList.size() == 0) return new DataResponse("401","Khong co tuyen xe nao phu hop!!!");
        return new DataResponse("200",tuyenXeList);
    }

    @PostMapping("/add")
    public DataResponse addNewTuyenXe(@RequestBody TuyenXeRequest tuyenXeRequest){
        if(tuyenXeRequest == null)throw new CustomException("404", "Missing Field");
        TuyenXe tuyenXe = tuyenXeService.addNewTuyenXe(tuyenXeRequest);
        if (tuyenXe==null)throw new CustomException("400","Khong tim thay ben xe!!!");
        return new DataResponse("200", tuyenXe);
    }
}