package oc.projet.biblio.consumer.repository;

import oc.projet.biblio.consumer.repository.custom.ExemplaireRepositoryCustom;
import org.springframework.data.repository.CrudRepository;

public interface ExemplaireRepository extends CrudRepository<ExemplaireRepository, Integer>, ExemplaireRepositoryCustom {


}
