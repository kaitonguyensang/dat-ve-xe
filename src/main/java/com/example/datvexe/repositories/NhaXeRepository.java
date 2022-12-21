package com.example.datvexe.repositories;

import com.example.datvexe.models.NhaXe;
import com.example.datvexe.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NhaXeRepository extends JpaRepository<NhaXe, Long> {
    NhaXe findNhaXeBySdt(String sdt);

}
