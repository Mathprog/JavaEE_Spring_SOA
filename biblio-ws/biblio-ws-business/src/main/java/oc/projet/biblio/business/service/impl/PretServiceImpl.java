package oc.projet.biblio.business.service.impl;

import oc.projet.biblio.business.service.PretService;
import oc.projet.biblio.model.repository.PretRepository;
import oc.projet.biblio.model.entity.Exemplaire;
import oc.projet.biblio.model.entity.Usager;
import oc.projet.biblio.model.entity.Pret;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;

@Service
@Transactional(propagation = Propagation.MANDATORY)
public class PretServiceImpl implements PretService {

    @Autowired
    private PretRepository pretRepository;

    @Override
    public Pret createPret(Exemplaire exemplaire, Usager usager, LocalDate date_pret, LocalDate date_fin) {
        Pret pret = this.pretRepository.create(exemplaire, usager, date_pret, date_fin);
        if( pret != null ){
            exemplaire.setPret(pret);
        }
        return pret;
    }
}
