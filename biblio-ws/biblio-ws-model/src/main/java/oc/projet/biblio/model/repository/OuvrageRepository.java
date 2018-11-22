package oc.projet.biblio.model.repository;

import oc.projet.biblio.model.entity.Ouvrage;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface OuvrageRepository {

    Ouvrage find(int id);

    List<Ouvrage> findAll();
    Ouvrage create(String nom);
    List<Object[]> findAllWithDispo();

    @Transactional(readOnly = true)
    List<Ouvrage> findAllWithNoDispo();
}
