/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atconsulting.antity;


import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


/**
 * 
 * @author vita
 */
@Document
public class Department {
    
    private static final String ID_PROPERTY ="id";
    private static final String NAME_PROPERTY="name";
    private static final String CODE_DEPARTAMENT_PROPERTY ="codeDepartment";
    
    @Id
    @JsonProperty(ID_PROPERTY)
    private String id;
    
    @JsonProperty(NAME_PROPERTY)
    private String name;
    
    @JsonProperty(CODE_DEPARTAMENT_PROPERTY)
    private String codeDepartment;
    
    
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public String getCodeDepartment() {
        return codeDepartment;
    }

    public void setCodeDepartment(String cxodeDepartment) {
        this.codeDepartment = codeDepartment;
    }

    @Override
    public String toString() {
        return "Department{" + "id=" + id + ", name=" + name + ", CodeDepartment=" + codeDepartment + '}';
    }

    public Department(String name, String codeDepartment) {
        this.name = name;
        this.codeDepartment = codeDepartment;
    }
    
    
}
