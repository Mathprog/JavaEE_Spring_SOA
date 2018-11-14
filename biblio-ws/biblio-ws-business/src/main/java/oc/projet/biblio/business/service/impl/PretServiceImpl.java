package oc.projet.biblio.business.service.impl;

import oc.projet.biblio.business.service.PretService;
import oc.projet.biblio.consumer.repository.PretRepository;
import oc.projet.biblio.model.entity.Exemplaire;
import oc.projet.biblio.model.entity.Pret;
import oc.projet.biblio.model.entity.Usager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class PretServiceImpl implements PretService {

    @Autowired
    private PretRepository pretRepository;

    @Override
    public Pret createPret(Exemplaire exemplaire, Usager usager, LocalDate date_pret, LocalDate date_fin) {
        return this.pretRepository.create(exemplaire, usager, date_pret, date_fin);
    }
}
