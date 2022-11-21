package com.example.datvexe.Repositories;

import com.example.datvexe.Models.Xe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface XeRepository extends JpaRepository<Xe, Long> {
}
