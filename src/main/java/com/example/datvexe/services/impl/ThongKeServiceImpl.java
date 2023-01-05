package com.example.datvexe.services.impl;

import com.example.datvexe.common.TrangThai;
import com.example.datvexe.handler.CustomException;
import com.example.datvexe.models.DanhGia;
import com.example.datvexe.models.HangHoa;
import com.example.datvexe.models.NhaXe;
import com.example.datvexe.models.VeXe;
import com.example.datvexe.payloads.requests.ThongKeAdminRequest;
import com.example.datvexe.payloads.responses.SaoTrungBinhAllResponse;
import com.example.datvexe.payloads.responses.ThongKeAdminDoanhThuResponse;
import com.example.datvexe.payloads.responses.ThongKeAdminUseResponse;
import com.example.datvexe.payloads.responses.ThongKeSaoResponse;
import com.example.datvexe.repositories.DanhGiaRepository;
import com.example.datvexe.repositories.HangHoaRepository;
import com.example.datvexe.repositories.NhaXeRepository;
import com.example.datvexe.repositories.VeXeRepository;
import com.example.datvexe.services.ThongKeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class ThongKeServiceImpl implements ThongKeService {

    @Autowired
    NhaXeRepository nhaXeRepository;

    @Autowired
    DanhGiaRepository danhGiaRepository;

    @Autowired
    VeXeRepository veXeRepository;

    @Autowired
    HangHoaRepository hangHoaRepository;

    @Override
    public float tinhTrungBinhSao(Long nhaXeId) {
        NhaXe nhaXe = nhaXeRepository.findNhaXeById(nhaXeId);
        if (nhaXe == null) throw new CustomException("404", "Khong tim thay nha xe!!!");
        List<DanhGia> danhGiaList = danhGiaRepository.findDanhGiasByNhaXe_Id(nhaXe.getId());
        int temp = 0;
        for (DanhGia danhGia : danhGiaList) {
            temp = temp + danhGia.getSoSao();
        }
        int size = danhGiaList.size();
        float temp1 = Float.valueOf(temp);
        float ketqua = temp1 / size;
        return ketqua;
    }

    @Override
    public ThongKeSaoResponse thongKeSaoRequest(Long nhaXeId) {
        NhaXe nhaXe = nhaXeRepository.findNhaXeById(nhaXeId);
        if (nhaXe == null) throw new CustomException("404", "Khong tim thay nha xe!!!");
        List<DanhGia> danhGiaList = danhGiaRepository.findDanhGiasByNhaXe_Id(nhaXe.getId());
        ThongKeSaoResponse thongKeSaoRequest = new ThongKeSaoResponse();
        int a[] = new int[5];
        for (DanhGia danhGia : danhGiaList) {
            a[danhGia.getSoSao() - 1] = a[danhGia.getSoSao() - 1] + 1;
        }
        thongKeSaoRequest.setSao1(a[0]);
        thongKeSaoRequest.setSao2(a[1]);
        thongKeSaoRequest.setSao3(a[2]);
        thongKeSaoRequest.setSao4(a[3]);
        thongKeSaoRequest.setSao5(a[4]);
        thongKeSaoRequest.setSoNguoiDanhGia(danhGiaList.size());
        return thongKeSaoRequest;
    }

    @Override
    public List<SaoTrungBinhAllResponse> getSaoTrungBinhAll() {
        List<NhaXe> nhaXeList = nhaXeRepository.findAll();
        List<SaoTrungBinhAllResponse> saoTrungBinhAllResponseList = new ArrayList<SaoTrungBinhAllResponse>();
        for (NhaXe nhaXe : nhaXeList) {
            SaoTrungBinhAllResponse saoTrungBinh = new SaoTrungBinhAllResponse();
            saoTrungBinh.setSaoTrungBinh(tinhTrungBinhSao(nhaXe.getId()));
            saoTrungBinh.setId(nhaXe.getId());
            if (Float.isNaN(saoTrungBinh.getSaoTrungBinh())) saoTrungBinh.setSaoTrungBinh(0F);
            saoTrungBinhAllResponseList.add(saoTrungBinh);
        }
        return saoTrungBinhAllResponseList;
    }

    @Override
    public List<ThongKeAdminUseResponse> getThongKeAdminUse(ThongKeAdminRequest thongKeAdminRequest) {
        List<VeXe> veXeList = veXeRepository.findVeXeByTrangThaiOrTrangThai(TrangThai.ACTIVE,TrangThai.COMPLETED);
        List<VeXe> veXes = new ArrayList<VeXe>();
        for (VeXe veXe : veXeList) {
            if (veXe.getNgayDat().getMonthValue() == thongKeAdminRequest.getMonth() && veXe.getNgayDat().getYear() == thongKeAdminRequest.getYear()) {
                veXes.add(veXe);
            }
        }
        List<HangHoa> hangHoaList = hangHoaRepository.findHangHoaByTrangThaiOrTrangThai(TrangThai.ACTIVE, TrangThai.COMPLETED);
        List<HangHoa> hangHoas = new ArrayList<HangHoa>();
        List<ThongKeAdminUseResponse> thongKeAdminUseResponseList = new ArrayList<ThongKeAdminUseResponse>();
        for (HangHoa hangHoa : hangHoaList) {
            if (hangHoa.getNgayDat().getMonthValue() == thongKeAdminRequest.getMonth() && hangHoa.getNgayDat().getYear() == thongKeAdminRequest.getYear()) {
                hangHoas.add(hangHoa);
            }
        }
        List<NhaXe> nhaXeList = nhaXeRepository.findAll();
        Float tongVe = (float) veXes.size();
        Float tongHangHoa = (float) hangHoas.size();
        for (NhaXe nhaXe : nhaXeList) {
            int tempVe = 0;
            int tempHangHoa = 0;
            ThongKeAdminUseResponse thongKeAdminUseResponse = new ThongKeAdminUseResponse();
            thongKeAdminUseResponse.setNhaXeId(nhaXe.getId());
            thongKeAdminUseResponse.setTenNhaXe(nhaXe.getTenNhaXe());
            for (VeXe veXe : veXes) {
                if (nhaXe.getId() == veXe.getTuyenXe().getXe().getNhaXe().getId()) {
                    tempVe = tempVe + 1;
                }
            }
            for (HangHoa hangHoaCheck : hangHoas) {
                if (nhaXe.getId() == hangHoaCheck.getTuyenXe().getXe().getNhaXe().getId())
                    tempHangHoa = tempHangHoa + 1;
            }
            thongKeAdminUseResponse.setSoSuatVe(tempVe);
            thongKeAdminUseResponse.setSoSuatHangHoa(tempHangHoa);
            thongKeAdminUseResponse.setTyLeVe(( tempVe/ tongVe)*100);
            if (tempVe ==0) thongKeAdminUseResponse.setTyLeVe(0);
            thongKeAdminUseResponse.setTyLeHangHoa(( tempHangHoa/ tongHangHoa)*100);
            if (tempHangHoa ==0) thongKeAdminUseResponse.setTyLeHangHoa(0);
            thongKeAdminUseResponseList.add(thongKeAdminUseResponse);
        }
        return thongKeAdminUseResponseList;
    }

    @Override
    public List<ThongKeAdminDoanhThuResponse> getThongKeAdminDoanhThu(ThongKeAdminRequest thongKeAdminRequest) {
        List<VeXe> veXeList = veXeRepository.findVeXeByTrangThaiOrTrangThai(TrangThai.ACTIVE,TrangThai.COMPLETED);
        List<VeXe> veXes = new ArrayList<VeXe>();
        for (VeXe veXe : veXeList) {
            if (veXe.getNgayDat().getMonthValue() == thongKeAdminRequest.getMonth() && veXe.getNgayDat().getYear() == thongKeAdminRequest.getYear()) {
                veXes.add(veXe);
            }
        }
        List<HangHoa> hangHoaList = hangHoaRepository.findHangHoaByTrangThaiOrTrangThai(TrangThai.ACTIVE, TrangThai.COMPLETED);
        List<HangHoa> hangHoas = new ArrayList<HangHoa>();
        List<ThongKeAdminDoanhThuResponse> thongKeAdminDoanhThuResponseList = new ArrayList<ThongKeAdminDoanhThuResponse>();
        for (HangHoa hangHoa : hangHoaList) {
            if (hangHoa.getNgayDat().getMonthValue() == thongKeAdminRequest.getMonth() && hangHoa.getNgayDat().getYear() == thongKeAdminRequest.getYear()) {
                hangHoas.add(hangHoa);
            }
        }
        List<NhaXe> nhaXeList = nhaXeRepository.findAll();
        int tongDoanhThu=0;
        for (NhaXe nhaXe : nhaXeList) {
            int tempDoanhThuVe = 0;
            int tempDoanhThuHangHoa = 0;
            ThongKeAdminDoanhThuResponse thongKeAdminDoanhThuResponse = new ThongKeAdminDoanhThuResponse();
            thongKeAdminDoanhThuResponse.setNhaXeId(nhaXe.getId());
            thongKeAdminDoanhThuResponse.setTenNhaXe(nhaXe.getTenNhaXe());
            for (VeXe veXe : veXes) {
                if (nhaXe.getId() == veXe.getTuyenXe().getXe().getNhaXe().getId()) {
                    tempDoanhThuVe = tempDoanhThuVe + veXe.getTuyenXe().getGiaVe();
                }
                tongDoanhThu = tongDoanhThu + veXe.getTuyenXe().getGiaVe();
            }
            for (HangHoa hangHoaCheck : hangHoas) {
                if (nhaXe.getId() == hangHoaCheck.getTuyenXe().getXe().getNhaXe().getId())
                    tempDoanhThuHangHoa = tempDoanhThuHangHoa + hangHoaCheck.getGia();
                tongDoanhThu = tongDoanhThu + hangHoaCheck.getGia();
            }
            thongKeAdminDoanhThuResponse.setDoanhThu(tempDoanhThuVe+tempDoanhThuHangHoa);
            thongKeAdminDoanhThuResponse.setTyLeDoanhThu((float) (tempDoanhThuVe+tempDoanhThuHangHoa)/(float) tongDoanhThu*100);
            thongKeAdminDoanhThuResponseList.add(thongKeAdminDoanhThuResponse);
        }
        return thongKeAdminDoanhThuResponseList;
    }

}

