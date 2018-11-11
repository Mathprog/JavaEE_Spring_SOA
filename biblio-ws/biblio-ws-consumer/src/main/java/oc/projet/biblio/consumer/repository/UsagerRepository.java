package oc.projet.biblio.consumer.repository;

import oc.projet.biblio.model.entity.Usager;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsagerRepository extends CrudRepository<Usager, Integer> {

    Usager findUsagerByEmail(String email);
}
