/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atconsulting.antity;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

/**
 *
 * @author vita
 */
@Document
public class Person {
    private static final String ID_PROPERTY ="id";
    private static final String NAME_PROPERTY="name";
    private static final String TYPE_PROPERTY="categoryRecipients";
    
    @Id
    @JsonProperty(ID_PROPERTY)
    private String id;
    
    @Field("FIO")
    @JsonProperty(NAME_PROPERTY)
    private String name;
    
    @JsonProperty(TYPE_PROPERTY)
    private CategoryRecipients type;

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

    public CategoryRecipients getType() {
        return type;
    }

    public void setType(CategoryRecipients type) {
        this.type = type;
    }

    public Person( String name, CategoryRecipients type) {
        this.name = name;
        this.type = type;
    }
    
    
    
}
