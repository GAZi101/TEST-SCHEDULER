/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.testjava.job;

import com.example.testjava.model.NilaiEntity;
import com.example.testjava.model.Siswa;
import com.example.testjava.parserer.CsvParserer;
import java.io.Reader;
import java.nio.file.Path;
import javax.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author PT. TRI DAYA ASIRA
 */
public class BulkInsertJob {

    protected String stringFilePath;
    protected CsvParserer cp;
    protected Reader reader;
    protected Path filePath;
    protected String tableName;
    protected String columnsName;
    private Integer numbersOfColumn;
    private String columnsParam;

    @Autowired
    private EntityManager em;

    public BulkInsertJob(String stringFilePath, String tableName, String columnsName, Integer numbersOfColumn) {
        this.stringFilePath = stringFilePath;
        this.tableName = tableName;
        this.columnsName = columnsName;
        this.numbersOfColumn = numbersOfColumn;
    }

    protected void doBulkInsert() {
        StringBuilder sb = new StringBuilder();
        int i = 0;
        while (i < numbersOfColumn) {
            sb = sb.append("?,");
            i++;
        }
        columnsParam = sb.toString().substring(0, sb.toString().length() - 1);

            em.createNativeQuery("insert into " + tableName + " (" + columnsName + ") value(" + columnsParam + ")").setParameter(stringFilePath, i);
    }
}
