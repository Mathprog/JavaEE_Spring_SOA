package oc.projet.biblio.business.service.impl;

import oc.projet.biblio.business.service.UsagerService;
import oc.projet.biblio.consumer.repository.UsagerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import oc.projet.biblio.model.entity.Usager;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;


@Service
@Transactional
public class UsagerServiceImpl implements UsagerService {


    @Autowired
    private UsagerRepository usagerRepository;

    @Override
    @Transactional
    public Usager createUsager(String email){
        return usagerRepository.createUsager(email);
    }

    @Override
    @Transactional
    public Usager findUsagerByEmail(String email) {
        return usagerRepository.findUsagerByEmail(email);
    }

    @Override
    @Transactional
    public Usager findUsager_pretsByEmail(String email){
        return usagerRepository.findUsager_pretsByEmail(email);
    }
}
