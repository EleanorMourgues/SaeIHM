/*
 * gestionPartie.java                                                    05/22
 */
package code;

import carte.Deck;
import carte.HanabiCarte;
import carte.Couleur;
import carte.Valeur;
import code.Joueur;


import java.util.ArrayList;
import java.util.Scanner;

/**
 * lancement d'une partie du jeu hanabi avec 3 joueurs
 * @author Idrissi Mohammed, Eléanor Mourgues, Charlie Sarrato-Boudet
 */
public class gestionPartie {
    
    static Joueur[] listeJoueur = {
            new Joueur("joueur 1"),
            new Joueur("joueur 2"),
            new Joueur("joueur 3"),
    };
    
    //creation des jeton
    static int jetonBleu = 7;
    static int jetonRouge = 3;
    
    static Deck deck = new Deck();
    
    //centre de la table vide
    static HanabiCarte[] centreTableRouge = new HanabiCarte [5];
    static HanabiCarte[] centreTableBleu = new HanabiCarte [5];
    static HanabiCarte[] centreTableRose = new HanabiCarte [5];
    static HanabiCarte[] centreTableVert = new HanabiCarte [5];
    static HanabiCarte[] centreTableBlanc = new HanabiCarte [5];
    
    
    //creation defausse
    static ArrayList<HanabiCarte> defausse = new ArrayList<HanabiCarte>();
    
    public static void main(String[] args) {
        
        String nom;
        HanabiCarte cartePosee;
        int action;
        
        Scanner entree = new Scanner(System.in);
        
        System.out.println("Joueur 1 saisissez votre pseudo (pas d'espace !) : ");
        nom = entree.next();
        listeJoueur[0].setNom(nom);
        System.out.println("Joueur 2 saisissez votre pseudo (pas d'espace !) : ");
        nom = entree.next();
        listeJoueur[1].setNom(nom);
        System.out.println("Joueur 3 saisissez votre pseudo (pas d'espace !) : ");
        nom = entree.next();
        listeJoueur[2].setNom(nom);
        
        Joueur joueurActuel = listeJoueur[0];
        
        //distribution des carte
        for (int i = 0; i < 5; i++) {
            joueurActuel.main.add(deck.getCarte(i));
        }
            
        joueurActuel = listeJoueur[1];
        
        for (int i = 0; i < 5; i++) {
            joueurActuel.main.add(deck.getCarte(i));
        }
        
        joueurActuel = listeJoueur[2];
        
        for (int i = 0; i < 5; i++) {
            joueurActuel.main.add(deck.getCarte(i));
        }
        
         
        joueurActuel = listeJoueur[0];
         
        //debut de la partie (condition fin de la partie)
        //while (jetonrouge <= 3 || deck.size() == 0) {
         
        //afficher les carte pour le joueur 1
        System.out.println("Joueur 2: " + listeJoueur[1].toStringMain());
         
        System.out.println("Joueur 3: " + listeJoueur[2].toStringMain());
         
        //differente action

        do {
            System.out.print("1: indice / 2: poser / 3: defausser / 4: re-ordonner :");
            action = entree.nextInt();
        } while (action < 1 && action > 4 );
         
        switch (action) {
         
        case 1 :
            joueurActuel.indice();
             
        case 2 :
            cartePosee = joueurActuel.poser();
            if(!(verifier(cartePosee))) {
                jetonRouge --;
                System.out.println("Vous avez perdue une vie ! \nLa carte que vous avez posé est déjà présente sur le centre");
                defausse.add(cartePosee);
            }
          
        case 3 :
            cartePosee = joueurActuel.defausser();
            defausse.add(cartePosee);
             
        case 4 :
            joueurActuel.ordonner();
        }
         
    
    //  }
    
    
    
    
    }
    
    /**
     * permet de vérifier si la carte posée n'est pas déjà présente sur le centre de la table
     * @param carte la carte posée
     * @return true si la carte posée n'est pas déjà présente sur le centre de la table, false sinon
     */
    public static boolean verifier(HanabiCarte carte) {
        boolean carteOK;
        Couleur couleur;
        Valeur valeur;
        couleur = carte.getCouleur();
        valeur = carte.getValeur();
        carteOK = false;
        
        if (couleur.equals(Couleur.blanc)) {
            if (!(valeur.equals(centreTableBlanc[0])) && !(valeur.equals(centreTableBlanc[1])) 
		&& !(valeur.equals(centreTableBlanc[2])) && !(valeur.equals(centreTableBlanc[3])) ) {
                if (valeur.equals(Valeur.un)) {
                    centreTableBlanc[0] = carte;
                } else if (valeur.equals(Valeur.deux)) {
                    centreTableBlanc[1] = carte;
                } else if (valeur.equals(Valeur.trois)) {
                    centreTableBlanc[2] = carte;
                } else if (valeur.equals(Valeur.quatre)) {
                    centreTableBlanc[3] = carte;   
                } else {
                    centreTableBlanc[4] = carte;
                }
                carteOK = true;
            }
        } else if (couleur.equals(Couleur.bleu)) {
            if (!(valeur.equals(centreTableBleu[0])) && !(valeur.equals(centreTableBleu[1])) 
		&& !(valeur.equals(centreTableBleu[2])) && !(valeur.equals(centreTableBleu[3])) ) {
                if (valeur.equals(Valeur.un)) {
                    centreTableBleu[0] = carte;
                } else if (valeur.equals(Valeur.deux)) {
                    centreTableBleu[1] = carte;
                } else if (valeur.equals(Valeur.trois)) {
                    centreTableBleu[2] = carte;
                } else if (valeur.equals(Valeur.quatre)) {
                    centreTableBleu[3] = carte;   
                } else {
                    centreTableBleu[4] = carte;
                }
                carteOK = true;
            }
        }  else if (couleur.equals(Couleur.rose)) {
            if (!(valeur.equals(centreTableRose[0])) && !(valeur.equals(centreTableRose[1])) 
		&& !(valeur.equals(centreTableRose[2])) && !(valeur.equals(centreTableRose[3])) ) {
                if (valeur.equals(Valeur.un)) {
                    centreTableRose[0] = carte;
                } else if (valeur.equals(Valeur.deux)) {
                    centreTableRose[1] = carte;
                } else if (valeur.equals(Valeur.trois)) {
                    centreTableRose[2] = carte;
                } else if (valeur.equals(Valeur.quatre)) {
                    centreTableRose[3] = carte;   
                } else {
                    centreTableRose[4] = carte;
                }
                carteOK = true;
            }
        }  else if (couleur.equals(Couleur.rouge)) {
            if (!(valeur.equals(centreTableRouge[0])) && !(valeur.equals(centreTableRouge[1])) 
		&& !(valeur.equals(centreTableRouge[2])) && !(valeur.equals(centreTableRouge[3])) ) {
                if (valeur.equals(Valeur.un)) {
                    centreTableRouge[0] = carte;
                } else if (valeur.equals(Valeur.deux)) {
                    centreTableRouge[1] = carte;
                } else if (valeur.equals(Valeur.trois)) {
                    centreTableRouge[2] = carte;
                } else if (valeur.equals(Valeur.quatre)) {
                    centreTableRouge[3] = carte;   
                } else {
                    centreTableRouge[4] = carte;
                }
                carteOK = true;
            }
        }  else {
            if (!(valeur.equals(centreTableVert[0])) && !(valeur.equals(centreTableVert[1])) 
		&& !(valeur.equals(centreTableVert[2])) && !(valeur.equals(centreTableVert[3])) ) {
                if (valeur.equals(Valeur.un)) {
                    centreTableVert[0] = carte;
                } else if (valeur.equals(Valeur.deux)) {
                    centreTableVert[1] = carte;
                } else if (valeur.equals(Valeur.trois)) {
                    centreTableVert[2] = carte;
                } else if (valeur.equals(Valeur.quatre)) {
                    centreTableVert[3] = carte;   
                } else {
                    centreTableVert[4] = carte;
                }
                carteOK = true;
            }
          
        }     
        return carteOK;
    }
    
}
