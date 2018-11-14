package oc.projet.biblio.model.entity;


import javax.persistence.*;
import java.util.Date;

@Entity
public class Relance {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "date_fin")
    @Temporal(TemporalType.DATE)
    private Date dateFin;

    @ManyToOne
    @JoinColumn(name = "pret_id")
    private Pret pret;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getDateFin() {
        return dateFin;
    }

    public void setDateFin(Date dateFin) {
        this.dateFin = dateFin;
    }

    public Pret getPret() {
        return pret;
    }

    public void setPret(Pret pret) {
        this.pret = pret;
    }
}
