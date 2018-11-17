package oc.projet.biblio.model.repository;

import oc.projet.biblio.model.entity.Usager;

public interface UsagerRepository {

   Usager findUsagerByEmail(String email);
   Usager createUsager(String email);
    Usager findUsager_pretsByEmail(String email);

    Usager findUsager_pretsDetailsByEmail(String email);
}
