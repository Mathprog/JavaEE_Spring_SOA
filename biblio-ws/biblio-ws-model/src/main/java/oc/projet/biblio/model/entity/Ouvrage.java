package oc.projet.biblio.model.entity;

import java.util.Set;

public interface Ouvrage {
    Integer getId();

    void setId(Integer id);

    String getTitre();

    void setTitre(String titre);

    Long getNbDispo();

    void setNbDispo(Long nbDispo);

    Set<Exemplaire> getExemplaires();

    void setExemplaires(Set<Exemplaire> exemplaires);
}
