package oc.projet.biblio.business.service;

import oc.projet.biblio.model.entity.Exemplaire;
import oc.projet.biblio.model.entity.Ouvrage;

import java.util.List;

public interface ExemplaireService {
    List<Exemplaire> findAllExemplaire();

    Exemplaire createSexemplaire(Ouvrage ouvrage);
}
