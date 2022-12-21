package com.example.datvexe.services.impl;

import com.example.datvexe.models.BenXe;
import com.example.datvexe.payloads.requests.BenXeRequest;
import com.example.datvexe.repositories.BenXeRepository;
import com.example.datvexe.services.BenXeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BenXeServiceImpl implements BenXeService {
    @Autowired
    BenXeRepository benXeRepository;

    public BenXe convertBenXeRequestToBenXe(BenXeRequest benXeRequest, BenXe benXe) {
        benXe.setTinhThanh(benXeRequest.getTinhThanh());
        benXe.setTenBenXe(benXeRequest.getTenBenXe());
        benXe.setDiaChiChiTiet(benXeRequest.getDiChiChiTiet());
        return benXe;
    }

    public List<BenXe> findAllBenXe() {
        return benXeRepository.findAll();
    }

    public BenXe findBenXeById(Long id) {
        return benXeRepository.findOneById(id);
    }

    public BenXe addNewBenXe(BenXeRequest benXe) {
        BenXe newBenXe = new BenXe();
        newBenXe = convertBenXeRequestToBenXe(benXe, newBenXe);
        return benXeRepository.save(newBenXe);
    }

    public BenXe updateBenXe(BenXeRequest benXe, Long id) {
        BenXe newBenXe = benXeRepository.findOneById(id);
        if (newBenXe == null) return null;
        newBenXe = convertBenXeRequestToBenXe(benXe, newBenXe);
        return benXeRepository.save(newBenXe);
    }

    public Long deleteBenXe(Long id) {
        BenXe newBenXe = benXeRepository.findOneById(id);
        if (newBenXe == null) return null;
        benXeRepository.delete(newBenXe);
        return newBenXe.getId();
    }
}
