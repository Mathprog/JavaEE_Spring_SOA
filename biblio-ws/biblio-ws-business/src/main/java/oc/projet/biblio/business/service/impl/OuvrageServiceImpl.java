package oc.projet.biblio.business.service.impl;

import oc.projet.biblio.business.service.OuvrageService;
import oc.projet.biblio.model.repository.OuvrageRepository;
import oc.projet.biblio.model.entity.Ouvrage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class OuvrageServiceImpl implements OuvrageService {

    @Autowired
    private OuvrageRepository ouvrageRepository;

    @Override
    @Transactional(readOnly = true)
    public List<Ouvrage> findAllOuvrage() {
        return ouvrageRepository.findAll();
    }

    @Override
    @Transactional
    public Ouvrage createOuvrate(String titre) {
        return this.ouvrageRepository.create(titre);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Ouvrage> findAllWithDispo(){
        List<Ouvrage> ouvrages = this.ouvrageRepository.findAllWithDispo();

        for (Ouvrage ouvrage: ouvrages) {
            ouvrage.setNbDispo(ouvrage.getExemplaires().size());
        }
        return ouvrages;
    }
}
