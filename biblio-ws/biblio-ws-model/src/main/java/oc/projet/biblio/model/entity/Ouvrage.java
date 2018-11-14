package oc.projet.biblio.model.entity;


import javax.persistence.*;
import java.util.Set;

@Entity
public class Ouvrage {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String titre;

    @Column(name = "nb_dispo")
    private int nbDispo;

    @OneToMany(mappedBy = "ouvrage", fetch = FetchType.LAZY)
    private Set<Exemplaire> exemplaires;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public int getNbDispo() {
        return nbDispo;
    }

    public void setNbDispo(int nbDispo) {
        this.nbDispo = nbDispo;
    }

    public Set<Exemplaire> getExemplaires() {
        return exemplaires;
    }

    public void setExemplaires(Set<Exemplaire> exemplaires) {
        this.exemplaires = exemplaires;
    }
}
