/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atconsulting.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author vita
 */
@Controller
public class PageController {
    
    private static final String MAIN_PAGE ="ATConsulting/";
    
     public PageController() {
        System.out.println("create controller");
    }
    
    @RequestMapping(MAIN_PAGE)
    public String getMainPage(){
        return "main";
    }
    
}
