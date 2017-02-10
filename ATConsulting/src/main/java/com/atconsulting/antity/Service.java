/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atconsulting.antity;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 *
 * @author vita
 */
@Document 
public class Service {
    
    private static final String ID_PROPERTY ="id";
    private static final String CODE_PURPOSE_PROPERTY="codePurpose";
    private static final String FORM_CODE_PROPERTY = "formCode";
    private static final String TYPE_PROPERTY="categoryRecipients";
    private static final String SUBSERVICES_PROPERTY = "subservices";
    private static final String DEPARTAMENT_PROPERTY= "departament";
    
    
    @Id
    @JsonProperty(ID_PROPERTY)
    private String id;
    
    @JsonProperty(CODE_PURPOSE_PROPERTY)
    private String codePurpose;
    
    @JsonProperty(FORM_CODE_PROPERTY)
    private String formCode;
    
    @JsonProperty(TYPE_PROPERTY)
    private CategoryRecipients type;
    
    @DBRef
    @JsonProperty(DEPARTAMENT_PROPERTY)
    private Department department;
    
    @DBRef
    @JsonProperty(SUBSERVICES_PROPERTY)
    private List<Subservice> subservices;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCodePurpose() {
        return codePurpose;
    }

    public void setCodePurpose(String codePurpose) {
        this.codePurpose = codePurpose;
    }

    public String getFormCode() {
        return formCode;
    }

    public void setFormCode(String formCode) {
        this.formCode = formCode;
    }

    public List<Subservice> getSubservices() {
        return subservices;
    }

    public void setSubservices(List<Subservice> subservices) {
        this.subservices = subservices;
    }

    public CategoryRecipients getType() {
        return type;
    }

    public void setType(CategoryRecipients type) {
        this.type = type;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    } 

    public Service(String codePurpose, String formCode, CategoryRecipients type, Department department, List<Subservice> subservices) {
        this.codePurpose = codePurpose;
        this.formCode = formCode;
        this.type = type;
        this.department = department;
        this.subservices = subservices;
    }
    
    
}
