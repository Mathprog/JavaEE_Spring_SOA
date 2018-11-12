package oc.projet.biblio.model.entity;

import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.util.List;

@Entity
public class Usager {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String email;

    @OneToMany(mappedBy = "usager")
    private List<Pret> prets;

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

    public List<Pret> getPrets() {
        return prets;
    }

    public void setPrets(List<Pret> prets) {
        this.prets = prets;
    }
}
