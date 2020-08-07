/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.testjava.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Data;

/**
 *
 * @author PT. TRI DAYA ASIRA
 */
@Entity
@Data
@Table(name = "bulk_insert_data_setting")
public class BulkInsertScheduleDataSettingParam {
    
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long orderIdx;
    
    @Column
    private String insertName;
    
    @Column 
    private String insertNameDesc;
    
    @Column
    private String tableName;
    
    @Column
    private String columnsName;
    
    @Column
    private Integer numbersOfColumn;
    
    @Column
    private String filePath;
    
    @Column
    private Boolean execute;
    
    @Column
    private String type;
    
}
