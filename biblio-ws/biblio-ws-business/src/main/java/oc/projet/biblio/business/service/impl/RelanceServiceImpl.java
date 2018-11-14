package oc.projet.biblio.business.service.impl;

import oc.projet.biblio.business.service.RelanceService;
import oc.projet.biblio.consumer.repository.RelanceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RelanceServiceImpl implements RelanceService {


    @Autowired
    private RelanceRepository relanceRepository;


}
