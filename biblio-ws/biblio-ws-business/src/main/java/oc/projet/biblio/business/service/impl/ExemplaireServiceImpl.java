package oc.projet.biblio.business.service.impl;


import oc.projet.biblio.business.service.ExemplaireService;
import oc.projet.biblio.model.repository.ExemplaireRepository;
import oc.projet.biblio.model.entity.Exemplaire;
import oc.projet.biblio.model.entity.Ouvrage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(propagation = Propagation.MANDATORY)
public class ExemplaireServiceImpl implements ExemplaireService {

    @Autowired
    private ExemplaireRepository exemplaireRepository;

    @Override
    public List<Exemplaire> findAllExemplaire() {
        return null;
    }

    @Override
    public Exemplaire createSexemplaire(Ouvrage ouvrage) {
        return this.exemplaireRepository.createExemplaire(ouvrage);
    }
}
