package oc.projet.biblio.business.service.impl;


import oc.projet.biblio.business.service.ExemplaireService;
import oc.projet.biblio.model.entity.Pret;
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
    public Exemplaire find(int id){
        return this.exemplaireRepository.find(id);
    }

    @Override
    public List<Exemplaire> findAllExemplaire() {
        return null;
    }

    @Override
    public Exemplaire createSexemplaire(Ouvrage ouvrage) {
        return this.exemplaireRepository.createExemplaire(ouvrage);
    }

    @Override
    public Exemplaire findByPret(Pret pret){
        return this.exemplaireRepository.findByPret(pret);
    }

    @Override
    public List<Exemplaire> findAll(){
        return this.exemplaireRepository.findAll();
    }

    @Override
    public List<Exemplaire> findAllByBook(Ouvrage ouvrage){
        return this.exemplaireRepository.findAllByOuvrage(ouvrage);
    }
}
