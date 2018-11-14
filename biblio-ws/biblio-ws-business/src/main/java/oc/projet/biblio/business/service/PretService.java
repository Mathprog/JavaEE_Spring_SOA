package oc.projet.biblio.business.service;

import oc.projet.biblio.model.entity.Exemplaire;
import oc.projet.biblio.model.entity.Pret;
import oc.projet.biblio.model.entity.Usager;

import java.time.LocalDate;

public interface PretService {

    Pret createPret(Exemplaire exemplaire, Usager usager, LocalDate date_pret, LocalDate date_fin);
}
