package com.example.datvexe.Services.Impl;

import com.example.datvexe.Models.BenXe;
import com.example.datvexe.Models.TuyenXe;
import com.example.datvexe.Payloads.Requests.TuyenXeRequest;
import com.example.datvexe.Repositories.BenXeRepository;
import com.example.datvexe.Repositories.TuyenXeRepository;
import com.example.datvexe.Services.TuyenXeService;
import com.example.datvexe.common.TrangThai;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TuyenXeServiceImpl implements TuyenXeService {
    @Autowired
    TuyenXeRepository tuyenXeRepository;

    @Autowired
    BenXeRepository benXeRepository;

    public TuyenXe convertTuyenXeRequestToTuyenXe(TuyenXeRequest tuyenXeRequest, TuyenXe tuyenXe) {
        tuyenXe.setThoiGianKhoiHanh(tuyenXeRequest.getThoiGianKhoiHanh());
        tuyenXe.setNgayDen(tuyenXeRequest.getNgayDen());
        tuyenXe.setGiaVe(tuyenXeRequest.getGiaVe());
        tuyenXe.setTrangThai(tuyenXeRequest.getTrangThai());
        BenXe benXeDi = benXeRepository.findOneById(tuyenXeRequest.getBenXeDi());
        if(benXeDi == null) return null;
        tuyenXe.setBenXeDi(benXeDi);
        BenXe benXeDen = benXeRepository.findOneById(tuyenXeRequest.getBenXeDen());
        if(benXeDen == null) return null;
        tuyenXe.setBenXeDen(benXeDen);
        return tuyenXe;
    }

    public TuyenXe findOneById(Long id){
        TuyenXe tuyenXe = tuyenXeRepository.findOneById(id);
        if(tuyenXe == null){
            return null;
        }
        return tuyenXe;
    }

    public List<TuyenXe> getAllBenXe(){
        return  tuyenXeRepository.findAll();
    }

    public List<TuyenXe> getTuyenXeByBenXeDiBenXeDenNgayDi(TuyenXeRequest tuyenXeRequest){
        BenXe benXeDi = benXeRepository.findOneById(tuyenXeRequest.getBenXeDi());
        if(benXeDi == null) return null;
        BenXe benXeDen = benXeRepository.findOneById(tuyenXeRequest.getBenXeDen());
        if(benXeDen == null) return null;
        return tuyenXeRepository.findTuyenXeByBenXeDiBenXeDenNgayDi(benXeDi,benXeDen, tuyenXeRequest.getThoiGianKhoiHanh());
    }

    public TuyenXe addNewTuyenXe(TuyenXeRequest tuyenXeRequest) {
        TuyenXe tuyenXe = new TuyenXe();
        tuyenXe= convertTuyenXeRequestToTuyenXe(tuyenXeRequest,tuyenXe);
        return tuyenXeRepository.save(tuyenXe);
    }
}
