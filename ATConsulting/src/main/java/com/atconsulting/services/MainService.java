/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atconsulting.services;

import com.atconsulting.antity.Claim;
import com.atconsulting.antity.Person;

/**
 *
 * @author vita
 */
public interface MainService {

    void addClaim(Claim claim);
    com.atconsulting.antity.Service saveService(com.atconsulting.antity.Service service);
    public void removeAll();

    public Person savePerson(Person person);
}
