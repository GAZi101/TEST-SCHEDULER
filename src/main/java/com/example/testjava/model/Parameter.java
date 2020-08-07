/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.testjava.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Data;

/**
 *
 * @author PT. TRI DAYA ASIRA
 */
@Entity
@Data
@Table(name = "tbl_parameter")
public class Parameter {
    
    @Id
    @Column
    private String parameter;
    
    @Column
    private String value;
    
}
