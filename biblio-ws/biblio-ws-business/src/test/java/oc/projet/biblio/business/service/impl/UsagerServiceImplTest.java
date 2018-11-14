package oc.projet.biblio.business.service.impl;

import oc.projet.biblio.business.service.UsagerService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.PropertySource;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@PropertySource("classpath*:application.properties")
@SpringBootTest
public class UsagerServiceImplTest {

    @Autowired
    private UsagerService usagerService;

    @Test
    public void saveUsager() {
        usagerService.saveUsager("creerpartest");
    }


}