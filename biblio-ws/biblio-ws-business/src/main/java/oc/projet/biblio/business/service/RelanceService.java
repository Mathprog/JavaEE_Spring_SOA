package oc.projet.biblio.business.service;

import oc.projet.biblio.model.entity.Pret;
import oc.projet.biblio.model.entity.Relance;

import java.util.Date;

public interface RelanceService {

    Relance createRelance(Pret pret, Date date_fin);

}
