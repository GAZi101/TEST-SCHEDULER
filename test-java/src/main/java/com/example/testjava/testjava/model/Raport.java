/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.testjava.testjava.model;

import java.util.List;
import javax.persistence.Entity;
import javax.persistence.Id;
import lombok.Data;

/**
 *
 * @author PT. TRI DAYA ASIRA
 */
@Entity
@Data
public class Raport {
    
    @Id
    private String id;
    private String nama;
    private String mataPelajaran;
    private Integer nilai;
//    private List<nilai> nilaiList;
}
