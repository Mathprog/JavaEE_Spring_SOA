package oc.projet.biblio.consumer.repository;

import oc.projet.biblio.model.entity.Exemplaire;
import oc.projet.biblio.model.entity.Ouvrage;

public interface ExemplaireRepository {

    Exemplaire createExemplaire(Ouvrage ouvrage);
}
