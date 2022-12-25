package com.example.datvexe.services;

import com.example.datvexe.models.VeXe;
import com.example.datvexe.payloads.requests.VeXeRequest;
import com.example.datvexe.payloads.responses.DataResponse;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface VeXeService {
    List<VeXe> getAllVeXeByUserId(Long userId);

    DataResponse addVeXe(VeXeRequest veXeRequest);
}
