package oc.projet.biblio.consumer.repository;

import oc.projet.biblio.consumer.repository.custom.PretRepositoryCustom;
import oc.projet.biblio.model.entity.Pret;
import org.springframework.data.repository.CrudRepository;

public interface PretRepository extends CrudRepository<Pret, Integer>, PretRepositoryCustom {

}
