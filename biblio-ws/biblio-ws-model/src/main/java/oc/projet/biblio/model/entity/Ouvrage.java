package oc.projet.biblio.model.entity;

import java.util.Set;

public interface Ouvrage {
    Integer getId();

    void setId(Integer id);

    String getTitre();

    void setTitre(String titre);

    int getNbDispo();

    void setNbDispo(int nbDispo);

    Set<Exemplaire> getExemplaires();

    void setExemplaires(Set<Exemplaire> exemplaires);
}
