package oc.projet.biblio.consumer.repository.impl;

import oc.projet.biblio.model.repository.OuvrageRepository;
import oc.projet.biblio.model.entity.Ouvrage;
import oc.projet.biblio.consumer.entity.impl.OuvrageImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;

import java.util.List;


@Repository
@Transactional(propagation = Propagation.MANDATORY)
public class OuvrageRepositoryImpl implements OuvrageRepository {

    @Autowired
    EntityManager entityManager;

    @Override
    public Ouvrage find(int id){
        return this.entityManager.find(Ouvrage.class, id);
    }

    @Override
    public List<Ouvrage> findAll() {
        return entityManager.createNamedQuery(OuvrageImpl.QN.FIND_ALL, Ouvrage.class).getResultList();

    }

    @Override
    public Ouvrage create(String titre) {
        Ouvrage ouvrage = new OuvrageImpl();
        ouvrage.setTitre(titre);
        entityManager.persist(ouvrage);
        return ouvrage;
    }

    @Override
    public List<Object[]> findAllWithDispo(){
        return entityManager.createNamedQuery(OuvrageImpl.QN.FIND_ALL_DISPO, Object[].class).getResultList();
    }

    @Override
    public List<Ouvrage> findAllWithNoDispo(){
        return entityManager.createNamedQuery(OuvrageImpl.QN.FIND_ALL_NOT_DISPO, Ouvrage.class).getResultList();
    }

    @Override
    public List<Ouvrage> findAllOuvrageByResearch(String titre){
        return entityManager.createNamedQuery(OuvrageImpl.QN.FIND_ALL_BY_RESEARCH, Ouvrage.class).setParameter("liketitre", "%" + titre + "%").getResultList();
    }
}
