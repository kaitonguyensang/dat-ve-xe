package com.example.datvexe.Repositories;

import com.example.datvexe.Models.HangHoa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HangHoaRepository extends JpaRepository<HangHoa, Long> {
}
