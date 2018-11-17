package oc.projet.biblio.consumer.repository.impl;

import oc.projet.biblio.consumer.repository.UsagerRepository;
import oc.projet.biblio.model.entity.Usager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;


@Repository
@Transactional(propagation = Propagation.MANDATORY)
public class UsagerRepositoryImpl implements UsagerRepository {


    @Autowired
    private EntityManager entityManager;


    @Override
    public Usager createUsager(String email) {
        Usager usager = new Usager();
        usager.setEmail(email);
        this.entityManager.persist(usager);
        return usager;
    }

    @Override
    public Usager findUsagerByEmail(String email) {
        //return entityManager.createQuery("SELECT u FROM Usager u WHERE u.email = :email", Usager.class).setParameter("email", email).getSingleResult();
        return entityManager.createNamedQuery("Usager.findByEmail", Usager.class).setParameter("email", email).getSingleResult();
    }

    @Override
    public Usager findUsager_pretsByEmail(String email){
        return entityManager.createNamedQuery("Usager.findPrets", Usager.class).setParameter("email", email).getSingleResult();
    }

    @Override
    public Usager findUsager_pretsDetailsByEmail(String email){
        return entityManager.createNamedQuery(Usager.QN.FIND_BY_EMAIL, Usager.class).setParameter("email", email).getSingleResult();
    }
}
