package oc.projet.biblio.consumer.repository;

import oc.projet.biblio.model.entity.Ouvrage;

import java.util.List;

public interface OuvrageRepository {

    List<Ouvrage> findAll();
    Ouvrage create(String nom);
    List<Ouvrage> findAllWithDispo();
}
