package oc.projet.biblio.model.repository;

import oc.projet.biblio.model.entity.Ouvrage;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface OuvrageRepository {

    List<Ouvrage> findAll();
    Ouvrage create(String nom);
    List<Ouvrage> findAllWithDispo();

    @Transactional(readOnly = true)
    List<Ouvrage> findAllWithNoDispo();
}
