package oc.projet.biblio.model.entity;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name ="pret")
public class Pret {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="usager_id", nullable = false)
    private Usager usager;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "exemplaire_id", nullable = false)
    private Exemplaire exemplaire;

    @OneToOne(mappedBy = "pret",
            fetch = FetchType.LAZY)
    private Relance relance;

    @Column(name = "date_pret")
    private LocalDate datePret;

    @Column(name ="date_fin")
    private LocalDate dateFin;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Usager getUsager() {
        return usager;
    }

    public void setUsager(Usager usager) {
        this.usager = usager;
    }

    public LocalDate getDatePret() {
        return datePret;
    }

    public void setDatePret(LocalDate datePret) {
        this.datePret = datePret;
    }

    public LocalDate getDateFin() {
        return dateFin;
    }

    public void setDateFin(LocalDate dateFin) {
        this.dateFin = dateFin;
    }

    public Exemplaire getExemplaire() {
        return exemplaire;
    }

    public void setExemplaire(Exemplaire exemplaire) {
        this.exemplaire = exemplaire;
    }

    public Relance getRelance() {
        return relance;
    }

    public void setRelance(Relance relance) {
        this.relance = relance;
    }
}
