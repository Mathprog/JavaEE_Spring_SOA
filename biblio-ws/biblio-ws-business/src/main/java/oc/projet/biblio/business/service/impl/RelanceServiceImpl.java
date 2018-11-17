package oc.projet.biblio.business.service.impl;

import oc.projet.biblio.business.service.RelanceService;
import oc.projet.biblio.model.repository.RelanceRepository;
import oc.projet.biblio.model.entity.Pret;
import oc.projet.biblio.model.entity.Relance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDate;

@Service
@Transactional
public class RelanceServiceImpl implements RelanceService {


    @Autowired
    private RelanceRepository relanceRepository;

    @Override
    @Transactional
    public Relance createRelance(Pret pret, LocalDate date_fin) {
        return this.relanceRepository.create(pret, date_fin);
    }
}
