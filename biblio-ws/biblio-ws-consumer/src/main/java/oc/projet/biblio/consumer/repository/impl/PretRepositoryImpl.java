package oc.projet.biblio.consumer.repository.impl;

import oc.projet.biblio.model.repository.PretRepository;
import oc.projet.biblio.model.entity.Exemplaire;
import oc.projet.biblio.model.entity.Pret;
import oc.projet.biblio.model.entity.Usager;
import oc.projet.biblio.consumer.entity.impl.PretImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;

import java.time.LocalDate;
import java.util.List;


@Repository
@Transactional(propagation = Propagation.MANDATORY)
public class PretRepositoryImpl implements PretRepository {

    @Autowired
    EntityManager entityManager;

    @Override
    public Pret find(int id){
        return entityManager.find(PretImpl.class, id);
    }

    @Override
    public Pret create(Exemplaire exemplaire, Usager usager, LocalDate date_pret, LocalDate date_fin) {
        Pret pret = new PretImpl();
        pret.setExemplaire(exemplaire);
        pret.setUsager(usager);
        pret.setDatePret(date_pret);
        pret.setDateFin(date_fin);
        entityManager.persist(pret);
        return pret;
    }

    @Override
    public List<Pret> findall(){
        return this.entityManager.createNamedQuery(PretImpl.QN.FIND_ALL, Pret.class).getResultList();
    }

    @Override
    public Pret findByExemplaire(Exemplaire e){
        Pret pret = null;
        try {
            pret = this.entityManager.createNamedQuery(PretImpl.QN.FIND_BY_EXEMPLAIRE, Pret.class).setParameter("exemplaire", e).getSingleResult();
        } catch (NoResultException nre){
            return null;
        }
        return pret;
    }

    @Override
    public List<Pret> findAllByUsager(Usager u){
        return this.entityManager.createNamedQuery(PretImpl.QN.FIND_ALL_BY_USAGER, Pret.class).setParameter("usager", u).getResultList();
    }


}
