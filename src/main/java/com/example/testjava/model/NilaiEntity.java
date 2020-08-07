/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.testjava.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import lombok.Data;

/**
 *
 * @author PT. TRI DAYA ASIRA
 */
@Entity
@Data
@Table(name = "tbl_nilai")
public class NilaiEntity {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long id;
    
    @Column(nullable = true)
    private String id_pelajar;
    
    @Column(name = "mata_pelajaran")
    private String mataPelajaran;
    
    @Column
    private Integer nilai;
    
//    @ManyToOne
//    @JoinColumn(name = "id", referencedColumnName = "id_pelajar")
//    private Siswa siswa;
}
