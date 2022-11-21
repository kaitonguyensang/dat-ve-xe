package com.example.datvexe.Services.Impl;

import com.example.datvexe.Models.BenXe;
import com.example.datvexe.Payloads.Requests.BenXeRequest;
import com.example.datvexe.Repositories.BenXeRepository;
import com.example.datvexe.Services.BenXeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BenXeServiceImpl implements BenXeService {
    @Autowired
    BenXeRepository benXeRepository;

    public BenXe convertBenXeRequestToBenXe(BenXeRequest benXeRequest, BenXe benXe) {
        benXe.setDiaChi(benXeRequest.getDiaChi());
        benXe.setTenBenXe(benXeRequest.getTenBenXe());
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
