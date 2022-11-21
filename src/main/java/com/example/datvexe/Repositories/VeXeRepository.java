package com.example.datvexe.Repositories;

import com.example.datvexe.Models.User;
import com.example.datvexe.Models.VeXe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VeXeRepository extends JpaRepository<VeXe, Long> {
    List<VeXe> getVeXeByUser(User user);
}
