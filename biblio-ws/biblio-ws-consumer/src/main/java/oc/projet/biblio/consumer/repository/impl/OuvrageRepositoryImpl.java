package oc.projet.biblio.consumer.repository.impl;

import oc.projet.biblio.consumer.repository.custom.OuvrageRepositoryCustom;
import oc.projet.biblio.model.entity.Ouvrage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;


@Repository
@Transactional
public class OuvrageRepositoryImpl implements OuvrageRepositoryCustom {

    @Autowired
    EntityManager entityManager;

    @Override
    @Transactional
    public Ouvrage create(String titre) {
        Ouvrage ouvrage = new Ouvrage();
        ouvrage.setTitre(titre);
        entityManager.persist(ouvrage);
        return ouvrage;
    }
}
