package oc.projet.biblio.consumer.repository.custom;

import oc.projet.biblio.model.entity.Pret;
import oc.projet.biblio.model.entity.Relance;

import java.util.Date;

public interface RelanceRepositoryCustom {

    Relance create(Pret pret, Date date_fin);
}
