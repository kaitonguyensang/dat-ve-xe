package com.example.datvexe.services;

import com.example.datvexe.models.TuyenXe;
import com.example.datvexe.payloads.requests.TuyenXeRequest;
import com.example.datvexe.payloads.requests.TuyenXeRequestByAddress;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface TuyenXeService {
    TuyenXe findOneById(Long id);

    List<TuyenXe> getAllBenXe();

    List<TuyenXe> getTuyenXeByBenXeDiBenXeDenNgayDi(TuyenXeRequest tuyenXeRequest);

    TuyenXe addNewTuyenXe(TuyenXeRequest tuyenXeRequest);

    public List<TuyenXe> getTuyenXeByBenXeDiBenXeDen(TuyenXeRequestByAddress tuyenXeRequest);
}
