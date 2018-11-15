package oc.projet.biblio.consumer.repository.impl;

import oc.projet.biblio.consumer.repository.UsagerRepository;
import oc.projet.biblio.model.entity.Usager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

@Repository
@Transactional
public class UsagerRepositoryImpl implements UsagerRepository {


    @Autowired
    private EntityManager entityManager
            ;


    @Override
    @Transactional
    public Usager createUsager(String email) {
        Usager usager = new Usager();
        usager.setEmail(email);
        this.entityManager.persist(usager);
        return usager;
    }

    @Override
    @Transactional
    public Usager findUsagerByEmail(String email) {
        return entityManager.createQuery("SELECT u FROM Usager u WHERE u.email = :email", Usager.class).setParameter("email", email).getSingleResult();
    }

    @Override
    @Transactional
    public Usager findUsager_pretsByEmail(String email){
        return entityManager.createQuery("SELECT u FROM Usager u JOIN FETCH u.prets p WHERE u.email = :email", Usager.class).setParameter("email", email).getSingleResult();
    }
}
