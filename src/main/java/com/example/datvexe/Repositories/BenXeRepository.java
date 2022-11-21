package com.example.datvexe.Repositories;

import com.example.datvexe.Models.BenXe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BenXeRepository extends JpaRepository<BenXe, Long> {
    List<BenXe> findAll();
    BenXe findOneById(Long id);
    BenXe save(BenXe value);
}
