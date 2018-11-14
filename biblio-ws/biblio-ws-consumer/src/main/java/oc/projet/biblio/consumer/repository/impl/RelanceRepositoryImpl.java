package oc.projet.biblio.consumer.repository.impl;

import oc.projet.biblio.consumer.repository.custom.RelanceRepositoryCustom;
import oc.projet.biblio.model.entity.Pret;
import oc.projet.biblio.model.entity.Relance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.util.Date;


@Repository
@Transactional
public class RelanceRepositoryImpl implements RelanceRepositoryCustom {

    @Autowired
    EntityManager entityManager;

    @Override
    @Transactional
    public Relance create(Pret pret, Date date_fin) {
        Relance relance = new Relance();
        relance.setDateFin(date_fin);
        relance.setPret(pret);
        return relance;
    }
}
