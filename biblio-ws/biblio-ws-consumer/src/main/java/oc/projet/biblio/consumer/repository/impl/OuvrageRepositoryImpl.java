package oc.projet.biblio.consumer.repository.impl;

import oc.projet.biblio.consumer.repository.OuvrageRepository;
import oc.projet.biblio.model.entity.Ouvrage;
import oc.projet.biblio.model.entity.impl.OuvrageImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;

import java.util.List;


@Repository
@Transactional
public class OuvrageRepositoryImpl implements OuvrageRepository {

    @Autowired
    EntityManager entityManager;

    @Override
    @Transactional(readOnly = true)
    public List<Ouvrage> findAll() {
        return entityManager.createQuery("SELECT u FROM OuvrageImpl u", Ouvrage.class).getResultList();

    }

    @Override
    @Transactional
    public Ouvrage create(String titre) {
        Ouvrage ouvrage = new OuvrageImpl();
        ouvrage.setTitre(titre);
        entityManager.persist(ouvrage);
        return ouvrage;
    }

    @Override
    @Transactional(readOnly = true)
    public List<Ouvrage> findAllWithDispo(){
        return entityManager.createNamedQuery("Ouvrage.findAllWithDispo", Ouvrage.class).getResultList();
    }
}
