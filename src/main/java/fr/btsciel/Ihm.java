package fr.btsciel;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class Ihm {
    static  GestionDesCoureurs gestion = null;

    static void listerParClassemenet () {
        System.out.print("   Nom" );
        for (int i = 0; i < 20 - "Nom".length(); i++) {
            System.out.print(" ");
        }
        System.out.print("Prénom" );
        for (int i = 0; i < 20 - "Prénom".length(); i++) {
            System.out.print(" ");
        }
        System.out.println("Temps\t   Ecart");

        for (int i = 0; i < gestion.getCoureurs().size(); i++) {
            System.out.print((i + 1) + " " );
            if(i < 9) {
                System.out.print(" ");
            }
            System.out.print(  gestion.getCoureurs().get(i).getNom() );

            for (int j = 0; j <  20 - gestion.getCoureurs().get(i).getNom().length();j++) {
                System.out.print(" ");
            }

            if(i > 0) {
                System.out.print( gestion.getCoureurs().get(i).getPrenom());
                for (int j = 0; j <  20 - gestion.getCoureurs().get(i).getPrenom().length();j++) {
                    System.out.print(" ");
                }
                System.out.println(gestion.getCoureurs().get(i).getClassemenet().format(DateTimeFormatter.ofPattern("hh:mm:ss")) + "\t\t" + gestion.getCoureurs().get(i).getEcartString(gestion.getCoureurs().get(0).getDuree()));
            } else {
                System.out.print( gestion.getCoureurs().get(i).getPrenom());
                for (int j = 0; j <  20 - gestion.getCoureurs().get(i).getPrenom().length();j++) {
                    System.out.print(" ");
                }
                System.out.println( gestion.getCoureurs().get(i).getClassemenet().format(DateTimeFormatter.ofPattern("hh:mm:ss")) + " " );
            }
        }
    }
    private static void lister () {
        int position = 1;

        System.out.print("   Nom" );
        for (int i = 0; i < 20 - "Nom".length(); i++) {
            System.out.print(" ");
        }
        System.out.print("Prénom" );
        for (int i = 0; i < 20 - "Prénom".length(); i++) {
            System.out.print(" ");
        }
        System.out.println("Temps");
        for (Coureur coureur : gestion.getCoureurs()) {
            System.out.print(position++ + " ");
            if(position <= 10) {
                System.out.print(" ");
            }
            System.out.print(coureur.getNom());
            for (int i = 0; i < 20 - coureur.getNom().length(); i++) {
                System.out.print(" ");
            }
            System.out.print(coureur.getPrenom());
            for (int i = 0; i < 20 - coureur.getPrenom().length(); i++) {
                System.out.print(" ");
            }
            System.out.println( coureur.getClassemenet().format(DateTimeFormatter.ofPattern("hh:mm:ss")));
        }
        /*gestion.getCoureurs().forEach((coureur) -> {
            System.out.println(pos[0]++ + " " +  coureur.getNom() + " " + coureur.getPrenom() + " " + coureur.getClassemenet().format(DateTimeFormatter.ISO_TIME));
        });*/
    }
    public static void main(String[] args) {

        try {
            gestion = new GestionDesCoureurs();
        } catch (IOException e) {
            System.err.println("IOException " + e.getMessage() );
        } catch (SQLException e) {
            System.err.println("SQL erreur " + e.getMessage() );
        } catch (ClassNotFoundException e) {
            System.err.println("Le connecteur MySql => " + e.getMessage() +  " n'est pas installé");
        }
        try {
            System.out.println("Enregistremente des genres");
            System.out.println("Le nombre de genres ajoutés est de  : " + gestion.insererLesGenres());
        } catch (SQLException e) {
            System.err.println("Erreur insertion des genres dans la BDD " + e.getMessage() );
        }
        try {
            System.out.println("Enregistremente des catégories");
            System.out.println("Le nombre de catégories ajoutées est de  : " + gestion.insererLesCategories());
        } catch (SQLException e) {
            System.err.println("Erreur insertion des catégories dans la BDD " + e.getMessage());
        }
        try {
            System.out.println("Enregistremente des coureurs");
            System.out.println("Le nombre de coureurs ajoutés est de  : " + gestion.insererLesCoureurs());
        } catch (SQLException e) {
            System.err.println("Erreur insertion des coureurs dans la BDD " + e.getMessage() );
        }
    }
}
