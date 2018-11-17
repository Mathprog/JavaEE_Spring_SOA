package oc.projet.biblio.model.repository;

import oc.projet.biblio.model.entity.Exemplaire;
import oc.projet.biblio.model.entity.Ouvrage;

public interface ExemplaireRepository {

    Exemplaire createExemplaire(Ouvrage ouvrage);
}
