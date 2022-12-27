package com.example.datvexe.repositories;

import com.example.datvexe.models.HangHoa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HangHoaRepository extends JpaRepository<HangHoa, Long> {
    HangHoa findHangHoaById(Long id);

    List<HangHoa> findHangHoaByUser_Id(Long userId);
    List<HangHoa> findHangHoaByTuyenXe_Id(Long tuyenXeId);
}
