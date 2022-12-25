package com.example.datvexe.services.impl;

import com.example.datvexe.common.TrangThai;
import com.example.datvexe.models.TuyenXe;
import com.example.datvexe.models.User;
import com.example.datvexe.models.VeXe;
import com.example.datvexe.payloads.requests.VeXeRequest;
import com.example.datvexe.payloads.responses.DataResponse;
import com.example.datvexe.repositories.TuyenXeRepository;
import com.example.datvexe.repositories.UserRepository;
import com.example.datvexe.repositories.VeXeRepository;
import com.example.datvexe.services.VeXeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VeXeServiceImpl implements VeXeService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    VeXeRepository veRepository;

    @Autowired
    TuyenXeRepository tuyenXeRepository;

    public VeXe convertVeXeRequestToVeXe(VeXeRequest veXeRequest, VeXe veXe) {
        veXe.setSoGhe(veXeRequest.getSoGhe());
        veXe.setNgayDat(veXeRequest.getNgayDat());
        veXe.setNgayNhan(veXeRequest.getNgayNhan());
        veXe.setHinhThucThanhToan(veXeRequest.getHinhThucThanhToan());
        veXe.setTuyenXe(tuyenXeRepository.findOneById(veXeRequest.getTuyenXeId()));
        veXe.setUser(userRepository.findUserById(veXeRequest.getUserId()));
        veXe.setTrangThai(veXeRequest.getTrangThai());
        return veXe;
    }

    public List<VeXe> getAllVeXeByUserId(Long id){
        User user = userRepository.findUserById(id);
        if(user == null) return null;
        List<VeXe> veXeList = veRepository.getVeXeByUser(user);
        return veXeList;
    }

    @Override
    public DataResponse addVeXe(VeXeRequest veXeRequest) {
        TuyenXe tuyenXe = tuyenXeRepository.findOneById(veXeRequest.getTuyenXeId());
        if (tuyenXe == null) return new DataResponse("1","/");
        VeXe veXeCheck = veRepository.findVeXeByTuyenXe_IdAndSoGhe(tuyenXe.getId(), veXeRequest.getSoGhe());
        if (veXeCheck != null) return new DataResponse("2","/");
        veXeRequest.setTrangThai(TrangThai.INACTIVE);
        VeXe veXeNew = new VeXe();
        veXeNew = convertVeXeRequestToVeXe(veXeRequest,veXeNew);
        if (veXeNew == null) return new DataResponse("3","/");
        veXeNew = veRepository.save(veXeNew);
        return new DataResponse("4", veXeNew);
    }
}
