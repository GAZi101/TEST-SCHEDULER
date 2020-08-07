/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.testjava.repo;

import com.example.testjava.model.Parameter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.stereotype.Repository;

/**
 *
 * @author PT. TRI DAYA ASIRA
 */
@Repository
public interface ParameterRepo extends JpaRepository<Parameter, String>, QuerydslPredicateExecutor<Parameter> {

    public Parameter findByParameter(String parameter);
}
