package oc.projet.biblio.business.service;

import oc.projet.biblio.model.entity.Pret;
import oc.projet.biblio.model.entity.Relance;
import oc.projet.biblio.model.entity.Usager;

import java.time.LocalDate;
import java.util.List;

public interface RelanceService {

    Relance find(int id);

    Relance createRelance(Pret pret, LocalDate date_fin);

    List<Relance> findAll();

    Relance findByPret(Pret pret);

    List<Relance> findAllByUsager(Usager usager);
}
