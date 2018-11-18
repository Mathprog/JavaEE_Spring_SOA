package oc.projet.biblio.consumer.entity.impl;

import oc.projet.biblio.model.entity.Exemplaire;
import oc.projet.biblio.model.entity.Ouvrage;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "ouvrage")
@NamedQueries({
        @NamedQuery(
                name = OuvrageImpl.QN.FIND_ALL,
                query = "SELECT o FROM OuvrageImpl o"
        ),
        @NamedQuery(
                name=OuvrageImpl.QN.FIND_ALL_DISPO,
                query="SELECT o FROM OuvrageImpl o " +
                        "LEFT JOIN o.exemplaires e " +
                        "LEFT JOIN e.pret p "+
                        "WHERE p.exemplaire IS NULL"
        ),
        @NamedQuery(
                name=OuvrageImpl.QN.FIND_ALL_NOT_DISPO,
                query="SELECT o FROM OuvrageImpl o " +
                        "LEFT JOIN o.exemplaires e " +
                        "LEFT JOIN e.pret p "+
                        "WHERE p.exemplaire IS NOT NULL"
        )
})
public class OuvrageImpl implements Ouvrage {

    public static class QN {
        public static final String FIND_ALL = "OuvrageImpl.findAll";
        public static final String FIND_ALL_DISPO = "OuvrageImpl.findAllWithDispo";
        public static final String FIND_ALL_NOT_DISPO = "OuvrageImpl.findAllWithNoDispo";
    }

    @Id
    @Column(name = "id", unique = true, nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name="titre", length = 255)
    private String titre;

    @Transient
    private int nbDispo;

    @OneToMany(mappedBy = "ouvrage", fetch = FetchType.LAZY, targetEntity = ExemplaireImpl.class)
    private Set<Exemplaire> exemplaires;

    @Override
    public Integer getId() {
        return id;
    }

    @Override
    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public String getTitre() {
        return titre;
    }

    @Override
    public void setTitre(String titre) {
        this.titre = titre;
    }

    @Override
    public int getNbDispo() {
        return nbDispo;
    }

    @Override
    public void setNbDispo(int nbDispo) {
        this.nbDispo = nbDispo;
    }

    @Override
    public Set<Exemplaire> getExemplaires() {
        return exemplaires;
    }

    @Override
    public void setExemplaires(Set<Exemplaire> exemplaires) {
        this.exemplaires = exemplaires;
    }
}
