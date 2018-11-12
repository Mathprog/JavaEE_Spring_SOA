package oc.projet.biblio.model.entity;


import javax.persistence.*;
import java.util.List;

@Entity
public class Ouvrage {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String titre;

    @Column(name = "nb_dispo")
    private int nbDispo;

    @OneToMany(mappedBy = "ouvrage")
    private List<Pret> prets;

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

    public List<Pret> getPrets() {
        return prets;
    }

    public void setPrets(List<Pret> prets) {
        this.prets = prets;
    }
}
