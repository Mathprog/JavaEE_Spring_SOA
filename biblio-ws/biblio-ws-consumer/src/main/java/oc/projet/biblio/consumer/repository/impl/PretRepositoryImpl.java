package oc.projet.biblio.consumer.repository.impl;

import oc.projet.biblio.consumer.repository.PretRepository;
import oc.projet.biblio.model.entity.Exemplaire;
import oc.projet.biblio.model.entity.Pret;
import oc.projet.biblio.model.entity.Usager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;

import java.time.LocalDate;


@Repository
@Transactional
public class PretRepositoryImpl implements PretRepository {

    @Autowired
    EntityManager entityManager;

    @Override
    @Transactional
    public Pret create(Exemplaire exemplaire, Usager usager, LocalDate date_pret, LocalDate date_fin) {
        Pret pret = new Pret();
        pret.setExemplaire(exemplaire);
        pret.setUsager(usager);
        pret.setDatePret(date_pret);
        pret.setDateFin(date_fin);
        entityManager.persist(pret);
        return pret;
    }
}
