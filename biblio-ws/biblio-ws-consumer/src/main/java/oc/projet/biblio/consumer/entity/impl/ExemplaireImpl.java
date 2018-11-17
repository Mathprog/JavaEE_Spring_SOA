package oc.projet.biblio.consumer.entity.impl;


import oc.projet.biblio.model.entity.Exemplaire;
import oc.projet.biblio.model.entity.Ouvrage;
import oc.projet.biblio.model.entity.Pret;


import javax.persistence.*;

@Entity
@Table(name="exemplaire")
public class ExemplaireImpl implements Exemplaire {

    @Id
    @Column(name = "id", unique = true, nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY, targetEntity = OuvrageImpl.class)
    @JoinColumn(name = "ouvrage_id")
    private Ouvrage ouvrage;

     @OneToOne(fetch = FetchType.LAZY, mappedBy = "exemplaire", cascade = CascadeType.ALL, targetEntity = PretImpl.class)
     private Pret pret;

    @Override
    public Integer getId() {
        return id;
    }

    @Override
    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public Ouvrage getOuvrage() {
        return ouvrage;
    }

    @Override
    public void setOuvrage(Ouvrage ouvrage) {
        this.ouvrage = ouvrage;
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
