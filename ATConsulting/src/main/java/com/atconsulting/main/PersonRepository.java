/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atconsulting.main;

import com.atconsulting.antity.Person;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 *
 * @author vita
 */
public interface PersonRepository extends MongoRepository<Person,String> {
    
}
