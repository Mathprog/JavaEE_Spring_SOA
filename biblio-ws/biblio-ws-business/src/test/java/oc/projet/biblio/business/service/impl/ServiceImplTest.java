package oc.projet.biblio.business.service.impl;

import oc.projet.biblio.business.service.*;
import oc.projet.biblio.model.entity.*;

import static org.junit.Assert.*;

import org.hibernate.exception.ConstraintViolationException;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.PropertySource;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;


import java.time.LocalDate;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@PropertySource("classpath*:application.properties")
@SpringBootTest
@Transactional(propagation = Propagation.REQUIRED)
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

    @Before
    @Rollback(false)
    public void populateBdd()
    {
        String email = "mathieu-martinez";
        String titre = "Spring Framework";
        Usager usager = usagerService.createUsager(email);
        Ouvrage ouvrage = ouvrageService.createOuvrate(titre);
        Exemplaire exemplaire = exemplaireService.createSexemplaire(ouvrage);
        Pret pret = pretService.createPret(exemplaire, usager, LocalDate.now(), LocalDate.now().plusWeeks(4));
        Relance relance = relanceService.createRelance(pret, LocalDate.now().plusWeeks(8));

    }

    @Test
    public void findUserByEmail_NotExisting(){
        String email = "mathieu-martin";
        Usager  usagerFound = usagerService.findUsagerByEmail(email);
        assertNull(usagerFound);
    }

    @Test
    @Rollback(false)
    public void createUserByEmail_AlreadyExisting(){
        String email = "mathieu-martinez";
        Usager usager = usagerService.createUsager(email);
        assertNull(usager);
    }


    @Test
    public void findUserByEmail_Existing(){
        String email = "mathieu-martinez";
        Usager  usagerFound = usagerService.findUsagerByEmail(email);
        assertEquals(usagerFound.getEmail(), email);
    }

    @Test
    public void findOuvrages_Existing(){
        List<Ouvrage> ouvrages = ouvrageService.findAllOuvrage();
        assertNotNull(ouvrages);
    }


}