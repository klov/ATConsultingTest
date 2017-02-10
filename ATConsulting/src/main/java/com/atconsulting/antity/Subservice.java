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
public class Subservice {
    
    private static final String ID_PROPERTY ="id";
    private static final String CODE_TARGET_NAME_PROPERTY = "codeTargetName";
    
    
    @Id
    @JsonProperty(ID_PROPERTY)
    private String id;
    
    @JsonProperty(CODE_TARGET_NAME_PROPERTY)
    private String codeTargetName;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCodeTargetName() {
        return codeTargetName;
    }

    public void setCodeTargetName(String codeTargetName) {
        this.codeTargetName = codeTargetName;
    }

    public Subservice(String codeTargetName) {
        this.codeTargetName = codeTargetName;
    }
    
    
    
}
