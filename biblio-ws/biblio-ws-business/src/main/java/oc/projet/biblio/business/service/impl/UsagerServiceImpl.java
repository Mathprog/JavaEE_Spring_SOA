package oc.projet.biblio.business.service.impl;

import oc.projet.biblio.business.service.UsagerService;
import oc.projet.biblio.model.repository.UsagerRepository;
import oc.projet.biblio.model.entity.Usager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;


@Service
@Transactional(propagation = Propagation.MANDATORY)
public class UsagerServiceImpl implements UsagerService {


    @Autowired
    private UsagerRepository usagerRepository;

    @Override
    public Usager createUsager(String email){
        return usagerRepository.createUsager(email);
    }

    @Override
    public Usager findUsagerByEmail(String email) {
        return usagerRepository.findUsagerByEmail(email);
    }

    @Override
    public Usager findUsager_pretsByEmail(String email){
        return usagerRepository.findUsager_pretsByEmail(email);
    }

    @Override
    public Usager findUsager_pretsDetailsByEmail(String email){
        return this.usagerRepository.findUsager_pretsDetailsByEmail(email);
    }
}
