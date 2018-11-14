package oc.projet.biblio.business.service;

import oc.projet.biblio.model.entity.Pret;
import oc.projet.biblio.model.entity.Relance;

import java.time.LocalDate;

public interface RelanceService {

    Relance createRelance(Pret pret, LocalDate date_fin);

}
