/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atconsulting.services;

import com.atconsulting.antity.Claim;
import com.atconsulting.antity.Person;
import com.atconsulting.antity.Subservice;
import com.atconsulting.main.ClaimRepository;
import com.atconsulting.main.DepartmentRepository;
import com.atconsulting.main.PersonRepository;
import com.atconsulting.main.ServiceRepository;
import com.atconsulting.main.SubserviceRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Обеспечивает операции для реализации которых необходимо работать с несколькими 
 * документами одновременно.
 * @author vita
 */
@Service
public class MainServiceImple implements MainService {
    @Autowired
    private DepartmentRepository departmentRepository;
    
    @Autowired
    private ClaimRepository claimRepository;
    
    @Autowired
    private  SubserviceRepository subserviceRepository ;
    
    @Autowired
    private ServiceRepository serviceRepository;
    
    @Autowired
    private PersonRepository personRepository;

    /**
     * Добавляет в MongoDB новую заявку. Перед сохранением в базе :
     * проверяется добавлены ли объекты связи, если они не добалены то 
     * сохраняет объекты связей.
     * @param claim - заявка
     */
    public void addClaim(Claim claim) {
       Claim c =  claimRepository.findByClaimID(claim.getClaimID());
       if(c!=null){
           throw new IllegalArgumentException("ClaimID must be unique");
       }
       if(claim.getPersonID().getId()==null){
           claim.setPersonID(personRepository.save(claim.getPersonID()));
       }
       if(claim.getServiceID().getId()==null){
           claim.setServiceID(saveService(claim.getServiceID()));
       }
       claimRepository.save(claim);
    }
    /**
     * Сохраняет объект услуги в MongoDB.  Сохраняет подуслуги в базе если они не сохранены, прежде чем сохранить услугу. 
     * @param service
     * @return 
     */
    public com.atconsulting.antity.Service saveService(com.atconsulting.antity.Service service) {
        List<Subservice> list = service.getSubservices();
        for(int i =0; i <list.size(); i++){
            if(list.get(i).getId()==null){
                list.set(i, subserviceRepository.save(list.get(i)));
            }
        }
        service.setSubservices(list);
        if(service.getDepartment().getId()==null){
            service.setDepartment(departmentRepository.save(service.getDepartment()));
        }
        return serviceRepository.save(service);
    }

    @Override
    public void removeAll() {
        claimRepository.deleteAll();
        serviceRepository.deleteAll();
        personRepository.deleteAll();
        subserviceRepository.deleteAll();
        departmentRepository.deleteAll();
    }

    @Override
    public Person savePerson(Person person) {
        return personRepository.save(person);
    }
    
    
}
