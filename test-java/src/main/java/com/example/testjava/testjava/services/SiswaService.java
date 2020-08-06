/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.testjava.testjava.services;

import com.example.testjava.testjava.model.QSiswa;
import com.example.testjava.testjava.model.Qnilai;
import com.example.testjava.testjava.model.Raport;
import com.example.testjava.testjava.model.Siswa;
import com.example.testjava.testjava.model.nilai;
import com.querydsl.core.types.dsl.Expressions;
import com.querydsl.jpa.impl.JPAQuery;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
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
public class SiswaService {

    @Autowired
    private EntityManager em;

    public JSONObject getSiswaRaportLIst(String id, String nama, String maPel, Integer nilai, PageRequest page) {
        JSONObject result = new JSONObject();
        List<Siswa> list = new ArrayList<>();
        List<Raport> raportList = new ArrayList<>();
        long count = 0;
//        String query = "select ts.id, ts.nama, tn.mata_pelajaran, tn.nilai "
//                + "from tbl_siswa ts inner join tbl_nilai tn on (tn.id= ts.id)";

        try {

            QSiswa qs = QSiswa.siswa;
            Qnilai qn = Qnilai.nilai1;

            JPAQuery<Siswa> q = new JPAQuery(em);
//            Query qu =  em.createQuery(query);

//            q = q.createQuery();
//qu = qu.
            q = q.from(qs).innerJoin(qn).on(qn.id_pelajar.eq(qs.id));

            if (StringUtils.isNotEmpty(id)) {
                q = q.where(qs.id.like(id + "%"));
            }
            if (StringUtils.isNotEmpty(nama)) {
                q = q.where(qs.nama.like(nama + "%"));
            }
            if (StringUtils.isNotEmpty(maPel)) {
                q = q.where(qn.mataPelajaran.like(maPel + "%"));
            }
            if (nilai != null) {
                q = q.where(qn.nilai.eq(nilai));
            }

            list = q.orderBy(qs.id.asc()).offset(page.getPageNumber()).limit(page.getPageSize()).fetch();

            for (Siswa siswa : list) {
                Raport raport = new Raport();
                
                raport.setId(siswa.getId());
                raport.setNama(siswa.getNama());
//                raport.setNilaiList(siswa.getNilai().);
                
                raportList.add(raport);
            }
            count = q.fetchCount();

        } catch (Exception e) {
            e.printStackTrace();
        }

        result.put("Result", "OK");
        result.put("Records", new JSONArray(raportList));
        result.put("TotalRecordCount", count);

        return result;
    }
}
