package oc.projet.biblio.model.entity;

import javax.persistence.*;
import java.util.Set;


@Entity
public class Usager {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

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
