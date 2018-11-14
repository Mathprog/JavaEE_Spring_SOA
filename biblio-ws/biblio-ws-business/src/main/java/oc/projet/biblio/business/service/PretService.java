package oc.projet.biblio.business.service;

import oc.projet.biblio.model.entity.Exemplaire;
import oc.projet.biblio.model.entity.Pret;
import oc.projet.biblio.model.entity.Usager;

import java.util.Date;

public interface PretService {

    Pret createPret(Exemplaire exemplaire, Usager usager, Date date_pret, Date date_fin);
}
