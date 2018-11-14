package oc.projet.biblio.model.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Pret {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="usager_id")
    private Usager usager;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "exemplaire_id", nullable = false)
    private Exemplaire exemplaire;

    @Column(name = "date_pret")
    @Temporal(TemporalType.DATE)
    private Date datePret;

    @Column(name ="date_fin")
    @Temporal(TemporalType.DATE)
    private Date dateFin;

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

    public Date getDatePret() {
        return datePret;
    }

    public void setDatePret(Date datePret) {
        this.datePret = datePret;
    }

    public Date getDateFin() {
        return dateFin;
    }

    public void setDateFin(Date dateFin) {
        this.dateFin = dateFin;
    }

    public Exemplaire getExemplaire() {
        return exemplaire;
    }

    public void setExemplaire(Exemplaire exemplaire) {
        this.exemplaire = exemplaire;
    }
}
