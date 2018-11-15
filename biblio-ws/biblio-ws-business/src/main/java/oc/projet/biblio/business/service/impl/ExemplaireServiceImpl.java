package oc.projet.biblio.business.service.impl;


import oc.projet.biblio.business.service.ExemplaireService;
import oc.projet.biblio.consumer.repository.ExemplaireRepository;
import oc.projet.biblio.model.entity.Exemplaire;
import oc.projet.biblio.model.entity.Ouvrage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ExemplaireServiceImpl implements ExemplaireService {

    @Autowired
    private ExemplaireRepository exemplaireRepository;

    @Override
    @Transactional(readOnly = true)
    public List<Exemplaire> findAllExemplaire() {
        return null;
    }

    @Override
    @Transactional
    public Exemplaire createSexemplaire(Ouvrage ouvrage) {
        return this.exemplaireRepository.createExemplaire(ouvrage);
    }
}
