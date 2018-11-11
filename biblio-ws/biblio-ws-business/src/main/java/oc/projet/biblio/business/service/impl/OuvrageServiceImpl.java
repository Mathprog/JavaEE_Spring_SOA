package oc.projet.biblio.business.service.impl;

import oc.projet.biblio.business.service.OuvrageService;
import oc.projet.biblio.consumer.repository.OuvrageRepository;
import oc.projet.biblio.model.entity.Ouvrage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OuvrageServiceImpl implements OuvrageService {

    @Autowired
    OuvrageRepository ouvrageRepository;

    @Override
    public List<Ouvrage> findAllOuvrage() {
        return ouvrageRepository.findAll();
    }
}
