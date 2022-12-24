package com.example.datvexe.services.impl;

import com.example.datvexe.handler.CustomException;
import com.example.datvexe.models.NhaXe;
import com.example.datvexe.payloads.responses.DataResponse;
import com.example.datvexe.repositories.NhaXeRepository;
import com.example.datvexe.services.NhaXeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NhaXeServiceImpl implements NhaXeService {

    @Autowired
    NhaXeRepository nhaXeRepository;

    @Override
    public List<NhaXe> getAll() {
        List<NhaXe> listNhaXe = nhaXeRepository.findAll();
        if (listNhaXe.size() == 0) return null;
        return listNhaXe;
    }
}
