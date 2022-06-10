/*
 * Menu.java                                                    05/22
 */

package code;

import java.util.Scanner;
import code.gestionPartie;

/**
 * Permet à l'utilisateur de choisir entre plusieurs choix
 * @author eleanor mourgues
 *
 */

public class Menu {
    /**
     * l'utilisateur doit choisir entre lancer une partie,
     * voir les règles du jeu et quitter le jeu
     * @param args arguments non utilisés
     */
    public static void main(String[] args) {
        
        Scanner entree = new Scanner(System.in);
        
        int choix;
        
        
        do {
        System.out.println("Lancer une partie : 1 " 
                           + "\nVoir les règles : 2 "
                           + "\nQuitter : 3 "
                           + "\nVotre choix : ");
        choix = entree.nextInt();
        } while (choix < 1 && choix > 3);
        
        
        switch (choix) {
        case 1 :
            gestionPartie.main(args);
        case 2 :
            System.out.println();
        case 3 : 
            
        }
    }
}
