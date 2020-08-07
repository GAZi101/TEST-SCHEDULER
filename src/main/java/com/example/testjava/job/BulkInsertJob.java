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

/**
 *
 * @author PT. TRI DAYA ASIRA
 */
public class BulkInsertJob {
    
    protected String folder;
    protected String fileName;
    protected CsvParserer cp;
    protected Reader reader;
    protected Path filePath;

    public BulkInsertJob(String folder, String fileName) {
        this.folder = folder;
        this.fileName = fileName;
        
    }
    
    protected void doBulkInsert(){
        
    }
}
