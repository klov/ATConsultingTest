package com.atconsulting.main;

import com.atconsulting.antity.CategoryRecipients;
import com.atconsulting.antity.Claim;
import com.atconsulting.antity.Department;
import com.atconsulting.antity.Person;
import com.atconsulting.antity.Service;
import com.atconsulting.antity.Subservice;
import com.atconsulting.services.MainService;
import java.security.SecureRandom;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author vita
 */
@SpringBootApplication(scanBasePackages = {"com.atconsulting.config"})
@EnableAutoConfiguration
@ComponentScan(basePackages = "com.atconsulting")
public class Main implements CommandLineRunner {

    @Autowired
    private MainService mainService;

    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);

    }

    @Override
    public void run(String... strings) throws Exception {
        mainService.removeAll();
        Person[] prs = {mainService.savePerson(new Person("Jon", CategoryRecipients.IE)),
            mainService.savePerson(new Person("Alex", CategoryRecipients.LE)),
            mainService.savePerson(new Person("Oleg", CategoryRecipients.NP))
        };
        
        Subservice[][] sbs = {{new Subservice("Subservice1"), new Subservice("Subservice2")}, {new Subservice("Subservice3"), new Subservice("Subservice4")}};
        List<List<Subservice>> lists = new LinkedList<List<Subservice>>();

        lists.add(Arrays.asList(sbs[0]));
        lists.add(Arrays.asList(sbs[1]));

        Department[] deps = {new Department("dep1", "code1"), new Department("dep2", "code2")};
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date[] dates = {dateFormat.parse("2017-03-27"),
            dateFormat.parse("2017-02-27"),
            dateFormat.parse("2017-01-27"),
            dateFormat.parse("2017-04-27"),
            dateFormat.parse("2017-05-27"),
            dateFormat.parse("2017-06-27"),
            dateFormat.parse("2017-07-27")};
        for (int i = 1; i < 20; i++) {
            SecureRandom secureRandom = new SecureRandom();
            CategoryRecipients cr = CategoryRecipients.NP;
            Department de = deps[secureRandom.nextInt(deps.length)];
            List<Subservice> l = lists.get(secureRandom.nextInt(lists.size()));
            Service s = new Service("codePurpose" + i, "formCode" + i, cr, de, l);
            Person p = prs[secureRandom.nextInt(prs.length)];
            Claim claim = new Claim("Claim" + i,
                    p,
                    s,"status",
                    dates[secureRandom.nextInt(dates.length)]);
            mainService.addClaim(claim);
        }

    }
}
