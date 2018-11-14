package oc.projet.biblio.consumer.repository.custom;

import oc.projet.biblio.model.entity.Exemplaire;
import oc.projet.biblio.model.entity.Pret;
import oc.projet.biblio.model.entity.Usager;

import java.util.Date;

public interface PretRepositoryCustom {

    Pret create(Exemplaire exemplaire, Usager usager, Date date_pret, Date date_fin);
}
