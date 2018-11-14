package oc.projet.biblio.consumer.repository;

import oc.projet.biblio.consumer.repository.custom.ExemplaireRepositoryCustom;
import oc.projet.biblio.model.entity.Exemplaire;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ExemplaireRepository extends CrudRepository<Exemplaire, Integer>, ExemplaireRepositoryCustom {


    List<Exemplaire> findAll();

}
