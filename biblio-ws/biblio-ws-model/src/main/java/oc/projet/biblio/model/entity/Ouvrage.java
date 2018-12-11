package oc.projet.biblio.model.entity;

import java.time.LocalDate;
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

    String getAuteur();

    void setAuteur(String auteur);

    String getResume();

    void setResume(String resume);

    abstract String getImage();

    abstract void setImage(String image);

    LocalDate getDate();

    void setDate(LocalDate date);
}
