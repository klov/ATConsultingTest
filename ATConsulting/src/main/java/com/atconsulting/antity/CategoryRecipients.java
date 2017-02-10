/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atconsulting.antity;

/**
 *
 * @author vita
 */
public enum CategoryRecipients {
    IE("ИП"),LE("ЮР"),NP("ФЛ");
    
    private String name; 

    private CategoryRecipients(String name) {
        this.name = name;
    }  
    
    public String getName(){
        return this.name;
    }
}
