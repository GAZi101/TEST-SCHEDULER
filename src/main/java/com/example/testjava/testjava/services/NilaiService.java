/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.testjava.testjava.services;

import com.example.testjava.testjava.model.QSiswa;
import com.example.testjava.testjava.model.NilaiEntity;
import com.example.testjava.testjava.model.QNilaiEntity;
import com.example.testjava.testjava.repo.NilaiRepo;
import com.querydsl.jpa.impl.JPAQuery;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import javax.persistence.EntityManager;
import org.apache.commons.lang3.StringUtils;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

/**
 *
 * @author PT. TRI DAYA ASIRA
 */
@Service
public class NilaiService {

    @Autowired
    private EntityManager em;
    @Autowired
    private NilaiRepo nr;

    public JSONObject updateNilai(String id, Integer nilainya) {
        NilaiEntity _nilai = new NilaiEntity();
        Optional<NilaiEntity> nilaiOpt = nr.findById(id);

        _nilai = nilaiOpt.get();
        _nilai.setNilai(nilainya);

        return new JSONObject(nr.save(_nilai));
    }

    public JSONObject deleteMatPel(String matPel) {
        JSONObject result = new JSONObject();
        List<NilaiEntity> nilaiList = new ArrayList<>();
        nilaiList = nr.findByMataPelajaran(matPel);
        
        for(NilaiEntity n : nilaiList){
            nr.delete(n);
        }

        result.put("Result", "OK");
        result.put("Records", new JSONArray(nilaiList));
        result.put("TotalRecordCount", nr.count());

        return result;
    }

    public JSONObject getNilaiLIst(String id, String maPel, Integer nilai, PageRequest page) {
        JSONObject result = new JSONObject();
        List<NilaiEntity> list = new ArrayList<>();
        long count = 0;

        try {

//            QSiswa qs = QSiswa.siswa;
            QNilaiEntity qn = QNilaiEntity.nilaiEntity;

            JPAQuery<NilaiEntity> q = new JPAQuery(em);

            q = q.from(qn);
//                    .leftJoin(cm).on(cmi.cif.eq(cm.cif));

            if (StringUtils.isNotEmpty(id)) {
                q = q.where(qn.id.like(id + "%"));
            }
            if (StringUtils.isNotEmpty(maPel)) {
                q = q.where(qn.mataPelajaran.like(maPel + "%"));
            }
            if (nilai != null) {
                q = q.where(qn.nilai.eq(nilai));
            }

            list = q.orderBy(qn.id.asc()).offset(page.getPageNumber()).limit(page.getPageSize()).fetch();
            count = q.fetchCount();

        } catch (Exception e) {
            e.printStackTrace();
        }

        result.put("Result", "OK");
        result.put("Records", new JSONArray(list));
        result.put("TotalRecordCount", count);

        return result;
    }
}
