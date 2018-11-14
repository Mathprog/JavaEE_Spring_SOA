package oc.projet.biblio.business.service.impl;

import oc.projet.biblio.business.service.PretService;
import oc.projet.biblio.consumer.repository.PretRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PretServiceImpl implements PretService {

    @Autowired
    private PretRepository pretRepository;


}
