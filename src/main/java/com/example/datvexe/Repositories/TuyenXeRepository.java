package com.example.datvexe.Repositories;

import com.example.datvexe.Models.BenXe;
import com.example.datvexe.Models.TuyenXe;
import org.hibernate.sql.Select;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface TuyenXeRepository extends JpaRepository<TuyenXe, Long> {

    TuyenXe findOneById(Long id);

    List<TuyenXe> findAll();

    @Query("Select OBJECT(t) From TuyenXe t where t.benXeDi=?1 and t.benXeDen=?2 ")
    List<TuyenXe> findTuyenXeByBenXeDiBenXeDenNgayDi(BenXe benXeDi, BenXe benXeDen);
}
