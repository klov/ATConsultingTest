/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atconsulting.antity;


import com.atconsulting.config.CustomLocalDateTimeSerializer;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import java.util.Date;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 *
 * @author vita
 */
@Document
public class Claim {
    
    private static final String ID_PROPERTY = "id";
    private static final String STATUS_PROPERTY="status";
    private static final String CREATE_DATA_PROPERTY="date";
    private static final String SERVICE_ID_PROPERTY = "serviceID";
    private static final String PERSON_ID_PROPERTY="personID";
    private static final String CLAIM_ID_PROPERTY="claimID";
    
    @Id
    @JsonProperty(ID_PROPERTY)
    private String id;
    
    @JsonProperty(CLAIM_ID_PROPERTY)
    private String claimID;
    
    @DBRef  
    @JsonProperty(PERSON_ID_PROPERTY)
    private Person personID;
    
    
    @DBRef   
    @JsonProperty(SERVICE_ID_PROPERTY)
    private Service serviceID;
    
    @JsonProperty(STATUS_PROPERTY)
    private String status;
  
    
    @JsonProperty(CREATE_DATA_PROPERTY)
    @JsonSerialize(using = CustomLocalDateTimeSerializer.class)
    private Date createDate;

    public String getClaimID() {
        return claimID;
    }

    public void setClaimID(String claimID) {
        this.claimID = claimID;
    }

    public Person getPersonID() {
        return personID;
    }

    public void setPersonID(Person personID) {
        this.personID = personID;
    }

    public Service getServiceID() {
        return serviceID;
    }

    public void setServiceID(Service serviceID) {
        this.serviceID = serviceID;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Claim(String claimID, Person personID, Service serviceID, String status, Date createDate) {
        this.claimID = claimID;
        this.personID = personID;
        this.serviceID = serviceID;
        this.status = status;
        this.createDate = createDate;
    }
    
    
}
