/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.testjava.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import lombok.Data;

/**
 *
 * @author PT. TRI DAYA ASIRA
 */
@Entity
@Data
@Table(name = "tbl_siswa")
public class Siswa {
  
    @Id
    @Column
    private String id;
    
    @Column
    private String nama;
    
    @Column
    private String kelas;
    
    @OneToMany(cascade=CascadeType.ALL)
    @JoinColumn(name = "id_pelajar", nullable = true)
    private List<NilaiEntity> nilai = new ArrayList<NilaiEntity>();
}
