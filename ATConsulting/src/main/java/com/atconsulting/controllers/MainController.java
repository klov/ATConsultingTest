/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atconsulting.controllers;

import com.atconsulting.antity.Claim;
import com.atconsulting.antity.Person;
import static com.atconsulting.controllers.MainController.APPLICATION;
import com.atconsulting.main.ClaimRepository;
import com.atconsulting.main.PersonRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author vita
 */
@RestController
@RequestMapping(path = APPLICATION, produces = MediaType.APPLICATION_JSON_VALUE)
public class MainController {
    public static final String APPLICATION ="ATConsulting/application";
    public static final String CLAIMN = "claim";
    public static final String PERSON = "person";
    
    private ClaimRepository claimRepository;
    private PersonRepository personRepository;

    public PersonRepository getPersonRepository() {
        return personRepository;
    }

    @Autowired(required = false)
    public void setPersonRepository(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    
    public ClaimRepository getClaimRepository() {
        return claimRepository;
    }

    @Autowired(required = false)
    public void setClaimRepository(ClaimRepository claimRepository) {
        this.claimRepository = claimRepository;
    }
    
    @RequestMapping(method = RequestMethod.GET, path = CLAIMN)
    public List<Claim> getClaims(){
       return  claimRepository.findAll();
    }
    
    @RequestMapping(method = RequestMethod.GET, path = PERSON)
    public List<Person> getPerson(){
        return personRepository.findAll();
    }
    
}
