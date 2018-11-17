package oc.projet.biblio.model.repository;

import oc.projet.biblio.model.entity.Exemplaire;
import oc.projet.biblio.model.entity.Pret;
import oc.projet.biblio.model.entity.Usager;

import java.time.LocalDate;

public interface PretRepository {

    Pret create(Exemplaire exemplaire, Usager usager, LocalDate date_pret, LocalDate date_fin);
}
