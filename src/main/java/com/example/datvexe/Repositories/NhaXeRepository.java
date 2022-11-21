package com.example.datvexe.Repositories;

import com.example.datvexe.Models.NhaXe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NhaXeRepository extends JpaRepository<NhaXe, Long> {
}
