package oc.projet.biblio.business.service;

import oc.projet.biblio.model.entity.Ouvrage;

import java.util.List;

public interface OuvrageService {

    List<Ouvrage> findAllOuvrage();

    Ouvrage createOuvrate(String titre);
    List<Ouvrage> findAllWithDispo();
}
