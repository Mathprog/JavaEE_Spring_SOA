package oc.projet.biblio.model.entity.impl;

import oc.projet.biblio.model.entity.Relance;
import oc.projet.biblio.model.entity.Pret;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name= "relance")
public class RelanceImpl implements Relance {

    @Id
    @Column(name = "id", unique = true, nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "date_fin")
    private LocalDate dateFin;

    @OneToOne(fetch = FetchType.LAZY, targetEntity = PretImpl.class)
    @JoinColumn(name = "pret_id")
    private Pret pret;

    @Override
    public int getId() {
        return id;
    }

    @Override
    public void setId(int id) {
        this.id = id;
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
    public Pret getPret() {
        return pret;
    }

    @Override
    public void setPret(Pret pret) {
        this.pret = pret;
    }
}
