package fr.btsciel;

import java.time.LocalTime;

public class Coureur extends Personne {
    private Categorie categorie;
    int id;
    int duree;

    public int getDuree() {
        return duree;
    }
    public LocalTime getDureeTime() {
        return LocalTime.ofSecondOfDay(duree);
    }

    public void setDuree(LocalTime duree) {
        this.duree = duree.toSecondOfDay();
    }
    public void setDuree(int tps) {
        this.duree = tps;
    }

    public Coureur(Genre genre, String nom, String prenom, int id, Categorie cat) {
        super(genre, nom, prenom);
        this.id = id;
        this.categorie = cat;
    }
    public Coureur(Genre genre, String nom, String prenom, Categorie cat, int temps) {
        super(genre, nom, prenom);
        this.setGenre(genre);
        this.setCategorie(cat);
        this.duree = temps;
    }

    public Coureur(Genre genre, String nom, String prenom, int id, Categorie categorie, LocalTime duree) {
        super(genre, nom, prenom);
        this.categorie = categorie;
        this.id = id;
        this.duree = duree.toSecondOfDay();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Coureur() {
    }



    public Categorie getCategorie() {
        return categorie;
    }

    public void setCategorie(Categorie categorie) {
        this.categorie = categorie;
    }

    public void setClassemenet(int tps) {
    }

    public LocalTime getClassemenet() {
        return LocalTime.ofSecondOfDay(duree);
    }

    public LocalTime getEcart(int temps) {
        return LocalTime.ofSecondOfDay(duree - temps);
    }
    public String getEcartString(int temps) {
        String sTemps;
        LocalTime time;
        if((duree - temps) > 0) {
            time = LocalTime.ofSecondOfDay(duree - temps);
            if((duree - temps) < 60) {
                sTemps = time.getSecond() + " s";
            } else if((duree - temps) < 3600) {
                sTemps = time.getMinute() + " min " + time.getSecond() + " s";
            } else {
                sTemps = time.getHour() + " h " + time.getMinute() + " min " + time.getSecond() + " s";
            }
        } else {
            time = LocalTime.ofSecondOfDay(temps - duree);
            if((temps - duree) < 60) {
                sTemps = ("- ") + time.getSecond() + " s";
            } else if((temps - duree) < 3600) {
                sTemps = ("- ") + time.getMinute() + " min " + time.getSecond() + " s";
            } else {
                sTemps = ("- ") + time.getHour() + " h " + time.getMinute() + " min " + time.getSecond() + " s";
            }
        }

        return sTemps;
    }
}
