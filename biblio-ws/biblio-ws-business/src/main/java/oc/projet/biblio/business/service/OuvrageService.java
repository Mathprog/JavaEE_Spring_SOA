package oc.projet.biblio.business.service;


import oc.projet.biblio.model.entity.Ouvrage;

import java.util.List;

public interface OuvrageService {

    List<Ouvrage> findAllOuvrage();

    Ouvrage find(int id);

    Ouvrage createOuvrate(String titre);
    List<Ouvrage> findAllWithDispo();

    List<Ouvrage> findAllWithNoDispo();

    List<Ouvrage> findAllByTitreResearch(String titre);
}
