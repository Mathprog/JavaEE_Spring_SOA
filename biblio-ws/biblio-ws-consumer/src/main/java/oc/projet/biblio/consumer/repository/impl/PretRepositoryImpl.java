package oc.projet.biblio.consumer.repository.impl;

import oc.projet.biblio.consumer.repository.custom.PretRepositoryCustom;
import oc.projet.biblio.model.entity.Exemplaire;
import oc.projet.biblio.model.entity.Pret;
import oc.projet.biblio.model.entity.Usager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.util.Date;


@Repository
@Transactional
public class PretRepositoryImpl implements PretRepositoryCustom {

    @Autowired
    EntityManager entityManager;

    @Override
    @Transactional
    public Pret create(Exemplaire exemplaire, Usager usager, Date date_pret, Date date_fin) {
        Pret pret = new Pret();
        pret.setExemplaire(exemplaire);
        pret.setUsager(usager);
        pret.setDatePret(date_pret);
        pret.setDateFin(date_fin);
        entityManager.persist(pret);
        return pret;
    }
}
