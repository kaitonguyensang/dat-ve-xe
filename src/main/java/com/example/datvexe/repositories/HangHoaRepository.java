package com.example.datvexe.repositories;

import com.example.datvexe.models.HangHoa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HangHoaRepository extends JpaRepository<HangHoa, Long> {
}
