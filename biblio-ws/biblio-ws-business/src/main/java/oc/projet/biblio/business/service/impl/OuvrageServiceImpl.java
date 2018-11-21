package oc.projet.biblio.business.service.impl;

import oc.projet.biblio.business.service.OuvrageService;
import oc.projet.biblio.model.repository.OuvrageRepository;
import oc.projet.biblio.model.entity.Ouvrage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional(propagation = Propagation.MANDATORY)
public class OuvrageServiceImpl implements OuvrageService {

    @Autowired
    private OuvrageRepository ouvrageRepository;

    @Override
    public Ouvrage createOuvrate(String titre) {
        return this.ouvrageRepository.create(titre);
    }

    @Override
    public List<Ouvrage> findAllOuvrage() {
        return ouvrageRepository.findAll();
    }

    @Override
    public List<Ouvrage> findAllWithDispo(){
        List<Object[]> ouvrages = this.ouvrageRepository.findAllWithDispo();
        List<Ouvrage> ouvragesReturn = new ArrayList<>();
        for (Object[] o : ouvrages){
            Ouvrage ouvrage = (Ouvrage) o[0];
            ouvrage.setNbDispo((Long) o[1]);
            ouvragesReturn.add(ouvrage);
        }
        return ouvragesReturn;
    }

    @Override
    public List<Ouvrage> findAllWithNoDispo(){
        return this.ouvrageRepository.findAllWithNoDispo();
    }


}
