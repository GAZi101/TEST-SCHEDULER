/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.testjava.testjava.dto;

import com.example.testjava.testjava.model.NilaiEntity;
import java.util.List;
import lombok.Data;

/**
 *
 * @author PT. TRI DAYA ASIRA
 */
@Data
public class RaportDto {
    
    private String id;
    private String nama;
    private String mataPelajaran;
    private Integer nilai;
    private List<NilaiEntity> nilaiList;
    
}
