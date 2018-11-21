package oc.projet.biblio.model.repository;

import oc.projet.biblio.model.entity.Pret;
import oc.projet.biblio.model.entity.Relance;
import java.time.LocalDate;
import java.util.List;

public interface RelanceRepository {

    Relance create(Pret pret, LocalDate date_fin);

    List<Relance> findALl();

    Relance findByPret(Pret pret);
}
