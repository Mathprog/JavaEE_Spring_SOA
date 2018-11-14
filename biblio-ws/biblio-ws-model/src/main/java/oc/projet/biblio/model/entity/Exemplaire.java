package oc.projet.biblio.model.entity;


import javax.persistence.*;

@Entity
public class Exemplaire {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "ouvrage_id")
    private Ouvrage ouvrage;

     @OneToOne(fetch = FetchType.LAZY, mappedBy = "exemplaire", cascade = CascadeType.ALL)
     private Pret pret;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Ouvrage getOuvrage() {
        return ouvrage;
    }

    public void setOuvrage(Ouvrage ouvrage) {
        this.ouvrage = ouvrage;
    }

    public Pret getPret() {
        return pret;
    }

    public void setPret(Pret pret) {
        this.pret = pret;
    }
}
