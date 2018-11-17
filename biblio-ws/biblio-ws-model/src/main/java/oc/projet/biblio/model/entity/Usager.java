package oc.projet.biblio.model.entity;

import javax.persistence.*;
import java.util.Set;


@Entity
@Table(name ="usager")
@NamedQueries({
        @NamedQuery(
                name= Usager.QN.FIND_BY_EMAIL,
                query="SELECT u FROM Usager u " +
                        "WHERE u.email = :email"
        ),
        @NamedQuery(
                name="Usager.findPrets",
                query ="SELECT u FROM Usager u " +
                        "JOIN FETCH u.prets p " +
                        "WHERE u.email = :email"
        ),
        @NamedQuery(
                name="Usager.findPretsDetails",
                query ="SELECT u FROM Usager u " +
                        "JOIN FETCH u.prets p " +
                        "JOIN FETCH p.relance r " +
                        "JOIN FETCH p.exemplaire e " +
                        "JOIN FETCH e.ouvrage o " +
                        "WHERE u.email = :email"
        )

})
public class Usager {

    public static class QN {
        public static final String FIND_BY_EMAIL = "Usager.findByEmail";
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name="email", length = 255)
    private String email;

    @OneToMany(mappedBy = "usager", fetch = FetchType.LAZY)
    private Set<Pret> prets;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Set<Pret> getPrets() {
        return prets;
    }

    public void setPrets(Set<Pret> prets) {
        this.prets = prets;
    }
}
