package fr.btsciel;

import java.io.Serializable;
import java.util.Locale;

public class Personne implements Serializable {
     private Genre genre;
    String nom;
    String prenom;

    public Genre getGenre() {
        return genre;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }



    public Personne() {
    }

    public Personne(Genre genre, String nom, String prenom) {
        this.setGenre(genre);
        this.setNom(nom);
        this.setPrenom(prenom);
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom.trim().toUpperCase();
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom.substring(0, 1).toUpperCase() + prenom.substring(1).trim().toLowerCase(Locale.ROOT);
    }

}

