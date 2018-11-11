package oc.projet.biblio.business.service;

import oc.projet.biblio.consumer.repository.UsagerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import oc.projet.biblio.model.entity.Usager;
import org.springframework.stereotype.Service;


@Service
public class UsagerService {


    @Autowired
    private UsagerRepository usagerRepository;


    public String saveUsager(String email){

        Usager newUsager = new Usager();
        newUsager.setEmail(email);
        usagerRepository.save(newUsager);
        return "saved";
    }
}
