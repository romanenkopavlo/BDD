package fr.btsciel;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Comparator;

public class GestionDesCoureurs {
    private ArrayList<Coureur> coureurs = new ArrayList();
    private Connection connection;
    private PreparedStatement preparedStatement;

    public int insererLesCategories() throws SQLException {
        boolean flag = false;
        StringBuffer query = new StringBuffer("INSERT INTO categorie (id, nom, ages) VALUES ");
        int ageDebut = 20, ageFin = 24;
        for (Categorie c : Categorie.values()) {
            query.append("(NULL, '" + c.toString() + "', '" + ageDebut + " - " + ageFin + " ans'),");
            ageDebut = ageFin + 1;
            ageFin = ageDebut + 4;
        }
        query.deleteCharAt(query.length() - 1);
        //
        //Add code here
        //
        return 0;
    }

    public int insererLesCoureurs () throws SQLException {
        int categorie = 0, genre = 0;
        StringBuffer query = new StringBuffer("INSERT INTO coureur (id, id_genre, nom, prenom, id_categorie, temps) VALUES");
        for (Coureur coureur : coureurs) {
            //
            //Add code here
            //
            ResultSet rs = null;
            if (rs.next()) {
                categorie = rs.getInt("id");
            }
            //
            //Add code here
            //
            if (rs.next()) {
                genre = rs.getInt("id");
            }
            query.append("(NULL," + genre + ", '" + coureur.getNom() + "', '" + coureur.getPrenom() + "'," + categorie +  ",'" + coureur.getDureeTime() +  "'),");
        }
        query.deleteCharAt(query.length() - 1);
        //
        //Add code here
        //
        return 0 ;
    }

    public int insererLesGenres() throws SQLException {
        boolean flag = false;
        StringBuffer query = new StringBuffer("INSERT INTO genre (id, type, nom) VALUES ");
        //
        //Add code here
        //
        for(Genre g : Genre.values()) {
            switch (g.toString().toUpperCase()) {
                case "F" :
                    query.append("(NULL, '" + g.toString() + "','Féminin' ),");
                    break;
                case "M" :
                    query.append("(NULL, '" + g.toString() + "','Masculin' ),");
                    break;
            }
        }
        query.deleteCharAt(query.length() - 1);
        //
        //Add code here
        //
        return 0;
    }

    public GestionDesCoureurs() throws IOException, SQLException, ClassNotFoundException {

        BufferedReader br = Files.newBufferedReader(Paths.get("course.txt"), Charset.defaultCharset());
        String line = null;
        do {
            line = br.readLine();
            if(line != null) {
                String [] s = line.split(",");
                Categorie cat = null ;
                Genre g ;
                if(s[0].trim().toUpperCase().equals("M")) {
                    g = Genre.M;
                } else {
                    g = Genre.F;
                }
                for (Categorie c :Categorie.values()) {
                    if(c.toString().equals(s[3].trim().toString())) {
                        cat = c;
                    }
                }
                int duree = Integer.parseInt(s[4].trim());
                Coureur coureur = new Coureur(g, s[1].trim(), s[2].trim(), cat, duree );
                coureurs.add(coureur);
            }
        } while (line != null);
    }

    public ArrayList<Coureur> getCoureurs() {
        return coureurs;
    }

    public void setCoureurs(ArrayList<Coureur> coureurs) {
        this.coureurs = coureurs;
    }

    public boolean sauvegarder(String s) {
        return true;
    }
}
