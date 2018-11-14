package oc.projet.biblio.business.service.impl;

import oc.projet.biblio.business.service.*;
import oc.projet.biblio.model.entity.Exemplaire;
import oc.projet.biblio.model.entity.Ouvrage;
import oc.projet.biblio.model.entity.Usager;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.PropertySource;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@PropertySource("classpath*:application.properties")
@SpringBootTest
public class ServiceImplTest {

    @Autowired
    private UsagerService usagerService;

    @Autowired
    private PretService pretService;

    @Autowired
    private ExemplaireService exemplaireService;

    @Autowired
    private OuvrageService ouvrageService;

    @Autowired
    private RelanceService relanceService;

    @Test
    public void populateBdd()
    {
        Usager usager = usagerService.createUsager("creerpartest");
        Ouvrage ouvrage = ouvrageService.createOuvrate("Spring Framework");
        Exemplaire exemplaire = exemplaireService.createSexemplaire(ouvrage);

    }


}