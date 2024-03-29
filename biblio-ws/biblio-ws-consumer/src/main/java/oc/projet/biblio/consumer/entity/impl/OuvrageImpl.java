package oc.projet.biblio.consumer.entity.impl;

import oc.projet.biblio.model.entity.Exemplaire;
import oc.projet.biblio.model.entity.Ouvrage;
import javax.persistence.*;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.time.LocalDate;
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
                        "FROM ExemplaireImpl e2 " +
                        "JOIN e2.ouvrage o2 " +
                        "WHERE o = o2)"
        ),
        @NamedQuery(
                name = OuvrageImpl.QN.FIND_ALL_BY_RESEARCH,
                query = "SELECT o, COUNT(e) " +
                        "FROM OuvrageImpl o " +
                        "LEFT JOIN o.exemplaires e " +
                        "WHERE o.titre LIKE :liketitre " +
                        "GROUP BY o"
        ),
        @NamedQuery(
                name=OuvrageImpl.QN.FIND_ALL_DISPO_BY_RESEARCH,
                query="SELECT o, COUNT(e)" +
                        "FROM OuvrageImpl o " +
                        "JOIN o.exemplaires e " +
                        "WHERE e.pret IS NULL AND o.titre LIKE :liketitre " +
                        "GROUP BY o "+
                        "HAVING COUNT(e) > 0"
        ),
        @NamedQuery(
                name=OuvrageImpl.QN.FIND_ALL_NOT_DISPO_BY_RESEARCH,
                query="SELECT o " +
                        "FROM OuvrageImpl o " +
                        "JOIN o.exemplaires e "+
                        "WHERE e.pret IS NOT NULL AND o.titre LIKE :liketitre "+
                        "GROUP BY o " +
                        "HAVING COUNT(e) = ( " +
                        "SELECT COUNT(e2) " +
                        "FROM ExemplaireImpl e2 " +
                        "JOIN e2.ouvrage o2 " +
                        "WHERE o = o2)"
        )
})
public class OuvrageImpl implements Ouvrage, Serializable {

    public static class QN {
        public static final String FIND_ALL = "OuvrageImpl.findAll";
        public static final String FIND_ALL_DISPO = "OuvrageImpl.findAllWithDispo";
        public static final String FIND_ALL_NOT_DISPO = "OuvrageImpl.findAllWithNoDispo";
        public static final String FIND_ALL_BY_RESEARCH = "OuvrageImpl.findAllByResearch";
        public static final String FIND_ALL_DISPO_BY_RESEARCH = "OuvrageImpl.findAllWithDispoBySearch";
        public static final String FIND_ALL_NOT_DISPO_BY_RESEARCH = "OuvrageImpl.findAllWithNoDispoByResearch";
    }


    @Id
    @Column(name = "id", unique = true, nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name="titre", length = 255)
    @Size(min=2, max = 255)
    private String titre;

    @Column(name="auteur", length = 80)
    @Size(min=2, max = 80)
    private String auteur;

    @Column(name = "resume", length = 500)
    @Size(min = 2, max = 500)
    private String resume;

    @Column(name = "date")
    @Past
    private LocalDate date;

    @Transient
    private Long nbDispo = 0L;

    @Lob
    @Column(name = "imageb", columnDefinition="BLOB")
    private byte[] imageb;

    @OneToMany(mappedBy = "ouvrage", fetch = FetchType.LAZY, targetEntity = ExemplaireImpl.class)
    private Set<Exemplaire> exemplaires;

    public OuvrageImpl() {
    }

    public OuvrageImpl(String titre, String auteur, String resume, LocalDate date, Long nbDispo) {
        this.titre = titre;
        this.auteur = auteur;
        this.resume = resume;
        this.date = date;
        this.nbDispo = nbDispo;
    }

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

    @Override
    public String getAuteur() {
        return auteur;
    }

    @Override
    public void setAuteur(String auteur) {
        this.auteur = auteur;
    }

    @Override
    public String getResume() {
        return resume;
    }

    @Override
    public void setResume(String resume) {
        this.resume = resume;
    }

    @Override
    public LocalDate getDate() {
        return date;
    }

    @Override
    public void setDate(LocalDate date) {
        this.date = date;
    }

    @Override
    public byte[] getImageb() {
        return imageb;
    }

    @Override
    public void setImageb(byte[] imageb) {
        this.imageb = imageb;
    }
}
