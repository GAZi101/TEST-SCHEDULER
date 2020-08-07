/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.testjava.controller;

import com.example.testjava.services.NilaiService;
import com.example.testjava.services.SiswaService;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author PT. TRI DAYA ASIRA
 */
@RestController
@RequestMapping("/")
public class RaportSiswaNilaiController {
    
    @Autowired
    private SiswaService ss;
    @Autowired
    private NilaiService ns;
    
    @RequestMapping("/getListRaport")
    @ResponseBody
    public ResponseEntity getListRaport(
            @RequestParam(name = "page", required = true) Integer page,
            @RequestParam(name = "pageSize", required = true) Integer pageSize,
            @RequestParam(name = "nomor_induk", required = false) String nomor_induk,
            @RequestParam(name = "mata_pelajaran", required = false) String mata_pelajaran,
            @RequestParam(name = "nama", required = false) String nama,
            @RequestParam(name = "nilai", required = false) Integer nilai
    ) throws Exception {
        JSONObject resl = ss.getSiswaRaportLIst(nomor_induk, nama, mata_pelajaran, nilai, PageRequest.of(page, pageSize));
        
        return new ResponseEntity(resl.toString(), HttpStatus.OK);
    }
    
    @RequestMapping("/update-nilai")
    @ResponseBody
    public ResponseEntity updateNilai(
            @RequestParam(name = "nomor_induk", required = false) String nomor_induk,
            @RequestParam(name = "nilai", required = false) Integer nilai
    ) throws Exception {
        JSONObject resl = ns.updateNilai(nomor_induk, nilai);
        
        return new ResponseEntity(resl.toString(), HttpStatus.OK);
    }
    
    @RequestMapping("/delete-matapelajaran")
    @ResponseBody
    public ResponseEntity deleteMatapelajaran(
            @RequestParam(name = "mata_pelajaran", required = false) String mata_pelajaran
    ) throws Exception {
        JSONObject resl = ns.deleteMatPel(mata_pelajaran);
        
        return new ResponseEntity(resl.toString(), HttpStatus.OK);
    }
    
}
