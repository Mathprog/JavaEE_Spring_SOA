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
                query="SELECT o, COUNT(e)" +
                        "FROM OuvrageImpl o " +
                        "JOIN o.exemplaires e " +
                        "WHERE e.pret IS NULL " +
                        "GROUP BY o "+
                        "HAVING COUNT(e) > 0"
        ),
        @NamedQuery(
                name=OuvrageImpl.QN.FIND_ALL_NOT_DISPO,
                query="SELECT o " +
                        "FROM OuvrageImpl o " +
                        "JOIN o.exemplaires e "+
                        "WHERE e.pret IS NOT NULL "+
                        "GROUP BY o " +
                        "HAVING COUNT(e) = ( " +
                        "SELECT COUNT(e2) " +
                        "FROM o.exemplaires e2 " +
                        "JOIN OuvrageImpl o2 " +
                        "WHERE o = o2)"
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
    private Long nbDispo;

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
    public Long getNbDispo() {
        return nbDispo;
    }

    @Override
    public void setNbDispo(Long nbDispo) {
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
