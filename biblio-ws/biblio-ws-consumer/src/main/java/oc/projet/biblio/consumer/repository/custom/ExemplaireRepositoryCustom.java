package oc.projet.biblio.consumer.repository.custom;

import oc.projet.biblio.model.entity.Exemplaire;
import oc.projet.biblio.model.entity.Ouvrage;

public interface ExemplaireRepositoryCustom {

    Exemplaire createExemplaire(Ouvrage ouvrage);
}
