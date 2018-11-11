package oc.projet.biblio.business.service.impl;

import oc.projet.biblio.business.service.UsagerService;
import oc.projet.biblio.consumer.repository.UsagerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import oc.projet.biblio.model.entity.Usager;
import org.springframework.stereotype.Service;


@Service
public class UsagerServiceImpl implements UsagerService {


    @Autowired
    private UsagerRepository usagerRepository;

    @Autowired
    private Usager newUsager;


    @Override
    public String saveUsager(String email){
        this.newUsager.setEmail(email);
        usagerRepository.save(newUsager);
        return "saved";
    }
}
