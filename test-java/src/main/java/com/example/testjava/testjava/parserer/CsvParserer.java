/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.testjava.testjava.parserer;

import com.opencsv.CSVReader;
import java.io.Reader;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author PT. TRI DAYA ASIRA
 */
public class CsvParserer {
    
    public List<String[]> readAll(Reader reader) throws Exception {
        CSVReader csvReader = new CSVReader(reader);
        List<String[]> list = new ArrayList<>();
        list = csvReader.readAll();
        
//        for (int i = 1; i < list.size(); i++) {
//            for (String isi : list.get(i)) {
//                System.out.println(" ini apa yaa : " + isi);
//            }
//            System.out.println(" ABIS");
//        }
        reader.close();
        csvReader.close();
        return list;
    }
    
    public String readAllExample() throws Exception {
        Path logFile = Paths.get("D:\\Project\\test-java\\input\\siswa.csv");
        Reader reader = Files.newBufferedReader(logFile, StandardCharsets.UTF_8);
        return this.readAll(reader).toString();
    }
    
}
