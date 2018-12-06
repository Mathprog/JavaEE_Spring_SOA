package oc.projet.biblio.client.business;



import oc.projet.biblio.client.consumer.generated.UsagerWS;

import java.util.List;

public interface UsagerService {

    UsagerWS find(int id);

    UsagerWS createUsager(String email);
    UsagerWS findUsagerByEmail(String email);
    UsagerWS findUsager_pretsByEmail(String email);
    UsagerWS findUsager_pretsDetailsByEmail(String email);

    List<UsagerWS> findAll();

    List<UsagerWS> findAllByRelanceDate();

    List<UsagerWS> findAllByPretDate();
}
