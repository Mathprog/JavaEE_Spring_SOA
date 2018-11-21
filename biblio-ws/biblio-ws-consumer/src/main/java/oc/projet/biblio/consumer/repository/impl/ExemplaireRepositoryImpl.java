package oc.projet.biblio.consumer.repository.impl;

import oc.projet.biblio.model.repository.ExemplaireRepository;
import oc.projet.biblio.model.entity.Exemplaire;
import oc.projet.biblio.model.entity.Ouvrage;
import oc.projet.biblio.consumer.entity.impl.ExemplaireImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;


@Repository
@Transactional(propagation = Propagation.MANDATORY)
public class ExemplaireRepositoryImpl implements ExemplaireRepository {

    @Autowired
    EntityManager entityManager;

    @Override
    public Exemplaire createExemplaire(Ouvrage ouvrage){
            Exemplaire exemplaire = new ExemplaireImpl();
            exemplaire.setOuvrage(ouvrage);
            entityManager.persist(exemplaire);
            return exemplaire;
    }
}
