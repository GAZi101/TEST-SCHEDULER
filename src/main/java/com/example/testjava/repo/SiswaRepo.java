/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.testjava.repo;

import com.example.testjava.model.Siswa;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 *
 * @author PT. TRI DAYA ASIRA
 */
@Repository
public interface SiswaRepo extends JpaRepository<Siswa, String>, QuerydslPredicateExecutor<Siswa>{
    
//    @Query(nativeQuery = true, value = "select ts.id, ts.nama, tn.mata_pelajaran, tn.nilai from "
//            + "tbl_siswa ts inner join tbl_nilai tn on tn.id = ts.id")
//    public List<Siswa> raportLists(@Param("customername") String customername, @Param("noktp") String noktp, @Param("tgllahir") Integer tgllahir, @Param("mothername") String mothername);
}
