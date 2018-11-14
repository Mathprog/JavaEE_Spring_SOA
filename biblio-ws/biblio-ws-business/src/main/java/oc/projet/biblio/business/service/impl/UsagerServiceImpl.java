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
        return usagerRepository.create(email);
    }
}
