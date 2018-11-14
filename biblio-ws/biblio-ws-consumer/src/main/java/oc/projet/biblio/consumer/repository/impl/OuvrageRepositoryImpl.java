package oc.projet.biblio.consumer.repository.impl;

import oc.projet.biblio.consumer.repository.OuvrageRepository;
import oc.projet.biblio.model.entity.Ouvrage;
import oc.projet.biblio.model.entity.Usager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.List;


@Repository
@Transactional
public class OuvrageRepositoryImpl implements OuvrageRepository {

    @Autowired
    EntityManager entityManager;

    @Override
    public List<Ouvrage> findAll() {
        return entityManager.createQuery("SELECT u FROM Ouvrage u", Ouvrage.class).getResultList();

    }

    @Override
    @Transactional
    public Ouvrage create(String titre) {
        Ouvrage ouvrage = new Ouvrage();
        ouvrage.setTitre(titre);
        entityManager.persist(ouvrage);
        return ouvrage;
    }
}
