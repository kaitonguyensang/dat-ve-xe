package com.example.datvexe.Services;

import com.example.datvexe.Models.TuyenXe;
import com.example.datvexe.Payloads.Requests.TuyenXeRequest;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface TuyenXeService {
    TuyenXe findOneById(Long id);

    List<TuyenXe> getAllBenXe();

    List<TuyenXe> getTuyenXeByBenXeDiBenXeDenNgayDi(TuyenXeRequest tuyenXeRequest);

    TuyenXe addNewTuyenXe(TuyenXeRequest tuyenXeRequest);
}
