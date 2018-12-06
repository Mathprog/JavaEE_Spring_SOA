package oc.projet.biblio.client.business;



import oc.projet.biblio.client.consumer.generated.ExemplaireWS;
import oc.projet.biblio.client.consumer.generated.OuvrageWS;
import oc.projet.biblio.client.consumer.generated.PretWS;
import oc.projet.biblio.client.consumer.generated.UsagerWS;

import java.util.List;

public interface ExemplaireService {
    ExemplaireWS find(int id);

    List<ExemplaireWS> findAllExemplaire();

    ExemplaireWS createExemplaire(OuvrageWS ouvrage);

    ExemplaireWS findByPret(PretWS pret);

    List<ExemplaireWS> findAll();

    List<ExemplaireWS> findAllByBook(OuvrageWS ouvrage);

    List<ExemplaireWS> findAllByUsager(UsagerWS usager);
}
