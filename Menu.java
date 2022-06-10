/*
 * Menu.java                                                    05/22
 */

package code;

import java.util.Scanner;
import code.gestionPartie;

/**
 * Permet à l'utilisateur de choisir entre plusieurs choix
 * @author Mohammed Idrissi, Eleanor Mourgues & Charlie Sarrato
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
            System.out.println("Le but de ce jeu coopératif "
                               + "est de réaliser le plus de "
                               + "suites de fleurs.\nVous êtes 3 "
                               + "joueurs et chaque joueur a acces "
                               + "aux cartes des autres "
                               + "mais il ne peut pas voir "
                               + "les siennes.\nA chaque tour, vous "
                               + "pouvez choisir entre poser une "
                               + "carte au centre de la table, "
                               + "donner un indice a un autre joueur "
                               + "en lui inidiquant toutes les carte "
                               + "d'une couleur ou toutes les cartes "
                               + "d'une valeur ou bien défausser une carte "
                               + "c'est-a-dire s'en debarrasser. De plus "
                               + "vous pouvez réordonner vos cartes."
                               + "\nVous disposez de 3 jetons de vie et "
                               + "de 8 jetons d'indice. Lorsque vous "
                               + "disposez une carte qui ne complete "
                               + "pas de suite au centre de la table, "
                               + "vous perdez un jeton de vie. Lorsque "
                               + "vous donnez un indice a quelqu'un, "
                               + "vous depensez un jeton d'indice."
                               + "\nPour recuperer un jeton d'indice, "
                               + "il suffit de defausser une carte."
                               + "\nLa partie se termine soit lorsque "
                               + "les 5 suites sont completes, soit "
                               + "si vous avez perdu vos 3 jetons "
                               + "de vie ou sinon si la "
                               + "pioche ne contient plus de cartes.");
        case 3 : 
            
        }
    }
}
