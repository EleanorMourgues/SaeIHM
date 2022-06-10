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
 * @author Idrissi Mohammed, Eléanor Mourgues, Charlie Sarrato-Boudet
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
	
	static Joueur[] listeJoueur = {
			new Joueur("joueur 1"),
			new Joueur("joueur 2"),
			new Joueur("joueur 3"),
	};
	
	static Deck deck = new Deck();
	
	static Joueur joueurActuel = listeJoueur[0];
	
	//creation defausse
	static ArrayList<HanabiCarte> defausse = new ArrayList<HanabiCarte>();
	
	public static void main(String[] args) {
		
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
		
		//creation des jeton
		int jetonbleu = 7;
		int jetonrouge = 3;
		
		int action;
		
		//centre de la table vide
		 HanabiCarte[][] CENTRE_TABLE = new HanabiCarte [5][5];
		 HanabiCarte[] centretablerouge = CENTRE_TABLE[0];
		 HanabiCarte[] centretablebleu = CENTRE_TABLE[1];
		 HanabiCarte[] centretablerose = CENTRE_TABLE[2];
		 HanabiCarte[] centretablevert = CENTRE_TABLE[3];
		 HanabiCarte[] centretableblanc = CENTRE_TABLE[4];
		 
		 
		 
		 //debut de la partie (condition fin de la partie)
		 //while (jetonrouge <= 3 || deck.size() == 0) {
		 
		 //afficher les carte pour le joueur 1
		 joueurActuel = listeJoueur[1];
		 System.out.println("Joueur 2: " + joueurActuel.toStringMain());
		 
		 joueurActuel = listeJoueur[2];
		 System.out.println("Joueur 3: " + joueurActuel.toStringMain());
		 
		 //differente action
		 Scanner entree = new Scanner(System.in);
		 do {
				System.out.print("1: indice / 2: poser / 3: defausser / 4: re-ordonner :");
				action = entree.nextInt();
			} while (action < 1 && action > 4);
		 
		 
	
	//	 }
	
	
	
	
	}
}
