package oc.projet.biblio.consumer.repository.impl;

import oc.projet.biblio.consumer.repository.custom.ExemplaireRepositoryCustom;
import oc.projet.biblio.model.entity.Exemplaire;
import oc.projet.biblio.model.entity.Ouvrage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

@Repository
@Transactional
public class ExemplaireRepositoryImpl implements ExemplaireRepositoryCustom {

    @Autowired
    EntityManager entityManager;

    @Override
    @Transactional
    public Exemplaire createExemplaire(Ouvrage ouvrage){
            Exemplaire exemplaire = new Exemplaire();
            exemplaire.setOuvrage(ouvrage);
            entityManager.persist(exemplaire);
            return exemplaire;
    }
}
