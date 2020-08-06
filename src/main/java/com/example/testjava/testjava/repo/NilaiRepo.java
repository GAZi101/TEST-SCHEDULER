/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.testjava.testjava.repo;

import com.example.testjava.testjava.model.Siswa;
import com.example.testjava.testjava.model.NilaiEntity;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.stereotype.Repository;

/**
 *
 * @author PT. TRI DAYA ASIRA
 */
@Repository
public interface NilaiRepo extends JpaRepository<NilaiEntity, String>, QuerydslPredicateExecutor<NilaiEntity>{
    
    public List<NilaiEntity> findByMataPelajaran(String mataPelajaran);
}
