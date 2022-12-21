package com.example.datvexe.repositories;

import com.example.datvexe.models.Admin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdminRepository extends JpaRepository<Admin, Long> {

     Admin findAdminBySdt(String sdt);

     Admin findAdminByCmnd(String cmnd);

     Admin findAdminByEmail(String email);
}
