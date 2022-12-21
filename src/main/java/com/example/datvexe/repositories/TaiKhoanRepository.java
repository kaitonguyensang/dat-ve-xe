package com.example.datvexe.repositories;
import com.example.datvexe.models.TaiKhoan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TaiKhoanRepository extends JpaRepository<TaiKhoan, Long> {

    TaiKhoan findTaiKhoanById(Long id);

    List<TaiKhoan> findAll();

    TaiKhoan findTaiKhoanByUsername(String username);

    TaiKhoan save(TaiKhoan value);
}
