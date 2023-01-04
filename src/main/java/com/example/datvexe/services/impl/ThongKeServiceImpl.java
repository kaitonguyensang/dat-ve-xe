package com.example.datvexe.services.impl;

import com.example.datvexe.handler.CustomException;
import com.example.datvexe.models.DanhGia;
import com.example.datvexe.models.NhaXe;
import com.example.datvexe.payloads.responses.SaoTrungBinhAllResponse;
import com.example.datvexe.payloads.responses.ThongKeSaoResponse;
import com.example.datvexe.repositories.DanhGiaRepository;
import com.example.datvexe.repositories.NhaXeRepository;
import com.example.datvexe.services.ThongKeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ThongKeServiceImpl implements ThongKeService{

    @Autowired
    NhaXeRepository nhaXeRepository;

    @Autowired
    DanhGiaRepository danhGiaRepository;

    @Override
    public float tinhTrungBinhSao(Long nhaXeId) {
        NhaXe nhaXe = nhaXeRepository.findNhaXeById(nhaXeId);
        if (nhaXe == null) throw new CustomException("404","Khong tim thay nha xe!!!");
        List<DanhGia> danhGiaList = danhGiaRepository.findDanhGiasByNhaXe_Id(nhaXe.getId());
        int temp = 0;
        for (DanhGia danhGia : danhGiaList){
            temp = temp +  danhGia.getSoSao();
        }
        int size = danhGiaList.size();
        float temp1 = Float.valueOf(temp);
        float ketqua = temp1/size;
        return ketqua;
    }

    @Override
    public ThongKeSaoResponse thongKeSaoRequest(Long nhaXeId) {
        NhaXe nhaXe = nhaXeRepository.findNhaXeById(nhaXeId);
        if (nhaXe == null) throw new CustomException("404","Khong tim thay nha xe!!!");
        List<DanhGia> danhGiaList = danhGiaRepository.findDanhGiasByNhaXe_Id(nhaXe.getId());
        ThongKeSaoResponse thongKeSaoRequest = new ThongKeSaoResponse();
        int a[] = new int[5];
        for (DanhGia danhGia : danhGiaList){
            a[danhGia.getSoSao()-1] = a[danhGia.getSoSao()-1] +1;
        }
        thongKeSaoRequest.setSao1(a[0]);
        thongKeSaoRequest.setSao2(a[1]);
        thongKeSaoRequest.setSao3(a[2]);
        thongKeSaoRequest.setSao4(a[3]);
        thongKeSaoRequest.setSao5(a[4]);
        thongKeSaoRequest.setSoNguoiDanhGia(danhGiaList.size());
        return thongKeSaoRequest;
    }

    @Override
    public List<SaoTrungBinhAllResponse> getSaoTrungBinhAll() {
        List<NhaXe> nhaXeList = nhaXeRepository.findAll();
        List<SaoTrungBinhAllResponse> saoTrungBinhAllResponseList = new ArrayList<SaoTrungBinhAllResponse>();
        for(NhaXe nhaXe : nhaXeList)
        {
            SaoTrungBinhAllResponse saoTrungBinh = new SaoTrungBinhAllResponse();
            saoTrungBinh.setSaoTrungBinh(tinhTrungBinhSao(nhaXe.getId()));
            saoTrungBinh.setId(nhaXe.getId());
            if (Float.isNaN(saoTrungBinh.getSaoTrungBinh())) saoTrungBinh.setSaoTrungBinh(0F);
            saoTrungBinhAllResponseList.add(saoTrungBinh);
        }
        return saoTrungBinhAllResponseList;
    }
}
