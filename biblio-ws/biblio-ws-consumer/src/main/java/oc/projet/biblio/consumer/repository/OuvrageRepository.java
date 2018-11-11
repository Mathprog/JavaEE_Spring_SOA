package oc.projet.biblio.consumer.repository;

import oc.projet.biblio.model.entity.Ouvrage;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface OuvrageRepository extends CrudRepository<Ouvrage, Integer> {

        List<Ouvrage> findAll();
}
