package oc.projet.biblio.consumer.repository;

import oc.projet.biblio.model.entity.Pret;
import oc.projet.biblio.model.entity.Relance;

import java.time.LocalDate;

public interface RelanceRepository {

    Relance create(Pret pret, LocalDate date_fin);
}
