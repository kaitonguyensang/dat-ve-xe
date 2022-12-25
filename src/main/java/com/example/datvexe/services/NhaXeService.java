package com.example.datvexe.services;

import com.example.datvexe.models.NhaXe;
import com.example.datvexe.payloads.requests.NhaXeRequest;
import com.example.datvexe.payloads.responses.DataResponse;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface NhaXeService {
    List<NhaXe> getAll();

    NhaXe getNhaXeById(Long id);
    DataResponse updateNhaXe(NhaXeRequest nhaXeRequest);
}
