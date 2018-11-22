package oc.projet.biblio.business.service;


import oc.projet.biblio.model.entity.Exemplaire;
import oc.projet.biblio.model.entity.Ouvrage;
import oc.projet.biblio.model.entity.Pret;

import java.util.List;

public interface ExemplaireService {
    Exemplaire find(int id);

    List<Exemplaire> findAllExemplaire();

    Exemplaire createSexemplaire(Ouvrage ouvrage);

    Exemplaire findByPret(Pret pret);

    List<Exemplaire> findAll();

    List<Exemplaire> findAllByBook(Ouvrage ouvrage);
}
