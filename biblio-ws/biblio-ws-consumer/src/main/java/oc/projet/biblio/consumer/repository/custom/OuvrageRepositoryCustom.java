package oc.projet.biblio.consumer.repository.custom;

import oc.projet.biblio.model.entity.Ouvrage;

public interface OuvrageRepositoryCustom {

    Ouvrage create(String nom);
}
