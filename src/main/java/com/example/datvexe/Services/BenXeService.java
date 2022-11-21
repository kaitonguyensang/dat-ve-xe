package com.example.datvexe.Services;

import com.example.datvexe.Models.BenXe;
import com.example.datvexe.Payloads.Requests.BenXeRequest;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface BenXeService {

    List<BenXe> findAllBenXe();

    BenXe findBenXeById(Long id);

    BenXe addNewBenXe(BenXeRequest benXeRequest);

    BenXe updateBenXe(BenXeRequest benXeRequest, Long id);

    Long deleteBenXe(Long id);
}
