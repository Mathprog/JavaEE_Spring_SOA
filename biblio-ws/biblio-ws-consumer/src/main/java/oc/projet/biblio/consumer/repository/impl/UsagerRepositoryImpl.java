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
    private EntityManager em;


    @Override
    @Transactional
    public Usager createUsager(String email) {
        Usager usager = new Usager();
        usager.setEmail(email);
        this.em.persist(usager);
        return usager;
    }

    @Override
    public Usager findUsagerByEmail(String email) {
        TypedQuery<Usager> query =
                em.createQuery("SELECT u FROM Usager u WHERE u.email = :email", Usager.class).setParameter("email", email);
        return query.getSingleResult();
    }
}
