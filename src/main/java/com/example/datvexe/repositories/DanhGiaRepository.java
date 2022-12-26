package com.example.datvexe.repositories;

import com.example.datvexe.models.DanhGia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DanhGiaRepository extends JpaRepository<DanhGia, Long> {

}
