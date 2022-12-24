package com.example.datvexe.services.impl;

import com.example.datvexe.models.BenXe;
import com.example.datvexe.models.TuyenXe;
import com.example.datvexe.payloads.requests.TuyenXeRequest;
import com.example.datvexe.payloads.requests.TuyenXeRequestByAddress;
import com.example.datvexe.repositories.BenXeRepository;
import com.example.datvexe.repositories.TuyenXeRepository;
import com.example.datvexe.services.TuyenXeService;
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
        tuyenXe.setNgayDi(tuyenXeRequest.getNgayDi());
        tuyenXe.setGioDi(tuyenXeRequest.getGioDi());
        tuyenXe.setThoiGianHanhTrinh(tuyenXeRequest.getThoiGianHanhTrinh());
        tuyenXe.setGiaVe(tuyenXeRequest.getGiaVe());
        tuyenXe.setTrangThai(tuyenXeRequest.getTrangThai());
        BenXe benXeDi = benXeRepository.findBenXeByTenBenXeLike(tuyenXeRequest.getTenBenXeDi());
        if(benXeDi == null) return null;
        tuyenXe.setBenXeDi(benXeDi);
        BenXe benXeDen = benXeRepository.findBenXeByTenBenXeLike(tuyenXeRequest.getTenBenXeDen());
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
        BenXe benXeDi = benXeRepository.findBenXeByTenBenXeLike(tuyenXeRequest.getTenBenXeDi());
        if(benXeDi == null) return null;
        BenXe benXeDen = benXeRepository.findBenXeByTenBenXeLike(tuyenXeRequest.getTenBenXeDen());
        if(benXeDen == null) return null;
        return tuyenXeRepository.findTuyenXeByBenXeDiLikeAndBenXeDenLikeAndNgayDiLike(benXeDi,benXeDen, tuyenXeRequest.getNgayDi());
    }

    public List<TuyenXe> getTuyenXeByBenXeDiBenXeDen(TuyenXeRequestByAddress tuyenXeRequest){
        return tuyenXeRepository.findTuyenXeByBenXeDi_TinhThanhContainsAndBenXeDen_TinhThanhContains(tuyenXeRequest.getBenXeDi(), tuyenXeRequest.getBenXeDen());
    }

    public TuyenXe addNewTuyenXe(TuyenXeRequest tuyenXeRequest) {
        TuyenXe tuyenXe = new TuyenXe();
        tuyenXe= convertTuyenXeRequestToTuyenXe(tuyenXeRequest,tuyenXe);
        if (tuyenXe==null) return null;
        return tuyenXeRepository.save(tuyenXe);
    }
}
