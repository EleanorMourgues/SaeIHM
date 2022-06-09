/*
 * Classe permettant de gérer une partie d'Hanabi
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
 * 
 * 
 *
 */
public class gestionPartie {
	
	static final HanabiCarte[][] SUITE_COMPLETE = {
			{new HanabiCarte(Couleur.rouge,Valeur.un),
			 new HanabiCarte(Couleur.rouge,Valeur.deux),
			 new HanabiCarte(Couleur.rouge,Valeur.trois),
			 new HanabiCarte(Couleur.rouge,Valeur.quatre),
			 new HanabiCarte(Couleur.rouge,Valeur.cinq)},
			
			{new HanabiCarte(Couleur.bleu,Valeur.un),
			 new HanabiCarte(Couleur.bleu,Valeur.deux),
			 new HanabiCarte(Couleur.bleu,Valeur.trois),
			 new HanabiCarte(Couleur.bleu,Valeur.quatre),
			 new HanabiCarte(Couleur.bleu,Valeur.cinq)},
			
			{new HanabiCarte(Couleur.rose,Valeur.un),
			 new HanabiCarte(Couleur.rose,Valeur.deux),
			 new HanabiCarte(Couleur.rose,Valeur.trois),
			 new HanabiCarte(Couleur.rose,Valeur.quatre),
			 new HanabiCarte(Couleur.rose,Valeur.cinq)},
			
			{new HanabiCarte(Couleur.vert,Valeur.un),
			 new HanabiCarte(Couleur.vert,Valeur.deux),
			 new HanabiCarte(Couleur.vert,Valeur.trois),
			 new HanabiCarte(Couleur.vert,Valeur.quatre),
			 new HanabiCarte(Couleur.vert,Valeur.cinq)},
			
			{new HanabiCarte(Couleur.blanc,Valeur.un),
			 new HanabiCarte(Couleur.blanc,Valeur.deux),
			 new HanabiCarte(Couleur.blanc,Valeur.trois),
			 new HanabiCarte(Couleur.blanc,Valeur.quatre),
			 new HanabiCarte(Couleur.blanc,Valeur.cinq)},
	};
	
	HanabiCarte carteMilieu[][] = new HanabiCarte[5][5];
		
	static Joueur[] listeJoueur = {
			new Joueur("joueur1"),
			new Joueur("joueur2"),
			new Joueur("joueur3"),
	};
	static Deck deck = new Deck();
	static Joueur joueurActuel = listeJoueur[0];
	static ArrayList<HanabiCarte> defausse = new ArrayList<HanabiCarte>();
	
	public static void main(String[] args) {
		
		for (int i = 0; i < 5; i++) {
			joueurActuel.main.add(i, deck.getCarte(0));
			deck.supprimerCarte(i);
		}
		defausse.add(joueurActuel.defausser());

		System.out.println(defausse.get(0));
	}
	
}
