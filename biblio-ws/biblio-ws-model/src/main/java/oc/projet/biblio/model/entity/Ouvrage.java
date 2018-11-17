package oc.projet.biblio.model.entity;


import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "ouvrage")
@NamedQueries({
        @NamedQuery(
                name="Ouvrage.findAllWithDispo",
                query="SELECT o FROM Ouvrage o " +
                        "LEFT JOIN o.exemplaires e " +
                        "LEFT JOIN e.pret p "+
                        "WHERE p.exemplaire IS NULL"
        ),
        @NamedQuery(
                name="Ouvrage.findAllWithNoDispo",
                query="SELECT o FROM Ouvrage o " +
                        "LEFT JOIN o.exemplaires e " +
                        "LEFT JOIN e.pret p "+
                        "WHERE p.exemplaire IS NOT NULL"
        ),
        @NamedQuery(
                name="Ouvrage.findAllOuvrage",
                query="SELECT o FROM Ouvrage o " +
                        "JOIN FETCH o.exemplaires e " +
                        "JOIN FETCH e.pret p"
        )

})
public class Ouvrage {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String titre;

    @Transient
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
