package oc.projet.biblio.consumer.entity.impl;


import oc.projet.biblio.model.entity.Usager;
import oc.projet.biblio.model.entity.Pret;

import javax.persistence.*;
import java.util.Set;


@Entity
@Table(name ="usager")
@NamedQueries({
        @NamedQuery(
                name = UsagerImpl.QN.FIND_ALL,
                query = "SELECT u FROM UsagerImpl u"
        ),
        @NamedQuery(
                name= UsagerImpl.QN.FIND_BY_EMAIL,
                query="SELECT u FROM UsagerImpl u " +
                        "WHERE u.email = :email"
        ),
        @NamedQuery(
                name = UsagerImpl.QN.FIND_ALL_PRETS,
                query ="SELECT u FROM UsagerImpl u " +
                        "JOIN FETCH u.prets p " +
                        "WHERE u.email = :email"
        ),
        @NamedQuery(
                name = UsagerImpl.QN.FIND_PRETS_DETAILS ,
                query ="SELECT u FROM UsagerImpl u " +
                        "JOIN FETCH u.prets p " +
                        "JOIN FETCH p.relance r " +
                        "JOIN FETCH p.exemplaire e " +
                        "JOIN FETCH e.ouvrage o " +
                        "WHERE u.email = :email"
        )

})
public class UsagerImpl implements Usager {

    public static class QN {
        public static final String FIND_BY_EMAIL = "UsagerImpl.findByEmail";
        public static final String FIND_ALL_PRETS = "UsagerImpl.findAllPrets";
        public static final String FIND_PRETS_DETAILS = "UsagerImpl.findPretsDetails";
        public static final String FIND_ALL = "UsagerImpl.findAll";
    }

    @Id
    @Column(name = "id", unique = true, nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name="email", length = 255, unique=true)
    private String email;

    @OneToMany(mappedBy = "usager", fetch = FetchType.LAZY, targetEntity = PretImpl.class)
    private Set<Pret> prets;

    @Override
    public Integer getId() {
        return id;
    }

    @Override
    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public String getEmail() {
        return email;
    }

    @Override
    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public Set<Pret> getPrets() {
        return prets;
    }

    @Override
    public void setPrets(Set<Pret> prets) {
        this.prets = prets;
    }
}
