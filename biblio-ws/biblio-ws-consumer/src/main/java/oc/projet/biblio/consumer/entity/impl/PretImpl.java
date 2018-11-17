package oc.projet.biblio.consumer.entity.impl;

import oc.projet.biblio.model.entity.Exemplaire;
import oc.projet.biblio.model.entity.Pret;
import oc.projet.biblio.model.entity.Relance;
import oc.projet.biblio.model.entity.Usager;


import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name ="pret")
public class PretImpl implements Pret {

    @Id
    @Column(name = "id", unique = true, nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @ManyToOne(fetch = FetchType.LAZY, targetEntity = UsagerImpl.class)
    @JoinColumn(name="usager_id", nullable = false)
    private Usager usager;

    @OneToOne(fetch = FetchType.LAZY, targetEntity = ExemplaireImpl.class)
    @JoinColumn(name = "exemplaire_id", nullable = false)
    private Exemplaire exemplaire;

    @OneToOne(mappedBy = "pret",
            fetch = FetchType.LAZY, targetEntity = RelanceImpl.class)
    private Relance relance;

    @Column(name = "date_pret")
    private LocalDate datePret;

    @Column(name ="date_fin")
    private LocalDate dateFin;

    @Override
    public int getId() {
        return id;
    }

    @Override
    public void setId(int id) {
        this.id = id;
    }

    @Override
    public Usager getUsager() {
        return usager;
    }

    @Override
    public void setUsager(Usager usager) {
        this.usager = usager;
    }

    @Override
    public LocalDate getDatePret() {
        return datePret;
    }

    @Override
    public void setDatePret(LocalDate datePret) {
        this.datePret = datePret;
    }

    @Override
    public LocalDate getDateFin() {
        return dateFin;
    }

    @Override
    public void setDateFin(LocalDate dateFin) {
        this.dateFin = dateFin;
    }

    @Override
    public Exemplaire getExemplaire() {
        return exemplaire;
    }

    @Override
    public void setExemplaire(Exemplaire exemplaire) {
        this.exemplaire = exemplaire;
    }

    @Override
    public Relance getRelance() {
        return relance;
    }

    @Override
    public void setRelance(Relance relance) {
        this.relance = relance;
    }
}
