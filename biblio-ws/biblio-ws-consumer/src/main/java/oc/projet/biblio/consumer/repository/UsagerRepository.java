package oc.projet.biblio.consumer.repository;

import oc.projet.biblio.model.entity.Usager;

public interface UsagerRepository {

   Usager findUsagerByEmail(String email);
   Usager createUsager(String email);
}
