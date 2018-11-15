package oc.projet.biblio.consumer.repository;

import oc.projet.biblio.model.entity.Usager;

import javax.transaction.Transactional;

public interface UsagerRepository {

   Usager findUsagerByEmail(String email);
   Usager createUsager(String email);

    @Transactional
    Usager findUsager_pretsByEmail(String email);
}
