package oc.projet.biblio.consumer.repository.impl;

import oc.projet.biblio.consumer.repository.custom.UsagerRepositoryCustom;
import oc.projet.biblio.model.entity.Usager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

@Repository
@Transactional
public class UsagerRepositoryImpl implements UsagerRepositoryCustom {


    @Autowired
    private EntityManager em;


    @Override
    @Transactional
    public Usager create(String email) {
        Usager usager = new Usager();
        usager.setEmail(email);
        this.em.persist(usager);
        return null;
    }
}
