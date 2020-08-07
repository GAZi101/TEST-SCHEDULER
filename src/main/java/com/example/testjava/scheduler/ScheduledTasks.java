/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.testjava.scheduler;

import com.example.testjava.job.BulkInsertJob;
import com.example.testjava.model.BulkInsertScheduleDataSettingParam;
import com.example.testjava.model.Siswa;
import com.example.testjava.model.NilaiEntity;
import com.example.testjava.parserer.CsvParserer;
import com.example.testjava.repo.BulkInsertDataSettingParamRepo;
import com.example.testjava.repo.NilaiRepo;
import com.example.testjava.repo.ParameterRepo;
import com.example.testjava.repo.SiswaRepo;
import java.io.Reader;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
//import org.hibernate.cfg.Environment;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 *
 * @author PT. TRI DAYA ASIRA
 */
@Component
@PropertySource("classpath:application.properties")
public class ScheduledTasks {

    @Autowired
    private SiswaRepo sr;

    @Autowired
    private NilaiRepo nr;

    @Autowired
    private BulkInsertDataSettingParamRepo bi;
    
    @Autowired
    private BulkInsertJob bijo;

    private static final Logger log = LoggerFactory.getLogger(ScheduledTasks.class);

    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");

    @Scheduled(cron = "${cronparam}")
    public void reportCurrentTime() {
        
        List<BulkInsertScheduleDataSettingParam> paramList = new ArrayList<>();
        try {

            paramList = bi.findAllByOrderByOrderIdx();

            for (BulkInsertScheduleDataSettingParam bid : paramList) {
                if (bid.getExecute()) {

                }
            }

//            Path logFile = Paths.get(pr.findByParameter("folder").getValue());
//            Reader reader = Files.newBufferedReader(logFile, StandardCharsets.UTF_8);
//            List<String[]> listSiswa = cp.readAll(reader);
//
//            for (int i = 1; i < listSiswa.size(); i++) {
//                System.out.println("id " + listSiswa.get(i)[0]);
//                System.out.println("nama " + listSiswa.get(i)[1]);
//                System.out.println("kelas " + listSiswa.get(i)[2]);
//                s.setId(listSiswa.get(i)[0]);
//                s.setNama(listSiswa.get(i)[1]);
//                s.setKelas(listSiswa.get(i)[2]);
//
//                sr.save(s);
//            }
//
//            Path logFileNilai = Paths.get(pr.findByParameter("folder").getValue());
//            Reader readerNilai = Files.newBufferedReader(logFileNilai, StandardCharsets.UTF_8);
//            List<String[]> listNilai = cp.readAll(readerNilai);
//
//            for (int i = 1; i < listNilai.size(); i++) {
//                n = new NilaiEntity();
//                System.out.println("id_pelajar " + listNilai.get(i)[0]);
//                System.out.println("mata pelajaran " + listNilai.get(i)[1]);
//                System.out.println("nilai " + listNilai.get(i)[2]);
//                n.setId_pelajar(listNilai.get(i)[0]);
//                n.setMataPelajaran(listNilai.get(i)[1]);
//                n.setNilai(Integer.valueOf(listNilai.get(i)[2]));
////                try {
//                n = nr.save(n);
//                System.out.println("id " + n.getId());
////                } catch (Exception e) {
////                    e.printStackTrace();
////                }
//            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        log.info("The time is now {}", dateFormat.format(new Date()));
    }
}
