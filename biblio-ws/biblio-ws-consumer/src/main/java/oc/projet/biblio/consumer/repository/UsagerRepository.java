package oc.projet.biblio.consumer.repository;

import oc.projet.biblio.consumer.repository.custom.UsagerRepositoryCustom;
import oc.projet.biblio.model.entity.Usager;
import org.springframework.data.repository.CrudRepository;


public interface UsagerRepository extends CrudRepository<Usager, Integer>, UsagerRepositoryCustom {

    Usager findUsagerByEmail(String email);

    Usager create(String email);
}
