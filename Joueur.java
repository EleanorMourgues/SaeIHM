/*
 * Classe permettant de cr�er un joueur
 * Joueur.java                                                    05/22
 */

package code;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import carte.HanabiCarte;
import carte.Deck;
import code.gestionPartie;
import java.util.Collections;

/**
 * Classe permettant de cr�er un joueur 
 * mais �galement contenant des m�thode qui lui sont propres
 * @author Mourgues El�anor
 * @version 1.0   
 */
public class Joueur {
	

	public static List<HanabiCarte> main = new ArrayList<HanabiCarte>(5);
	

	/* nom donn� par le joueur */
	public String nom;
	
	/**
	 * D�finition des caract�ristiques d'un joueur
	 * @param nom nom donn� par le joueur
	 */
	public Joueur(String nom) {
		/* contr�ler la validit� du nom */
		if (nom == null || nom.isBlank()) {
			throw new IllegalArgumentException("nom invalide");
	    }
		
		this.nom = nom;
	}


	public String getNom() {
		return nom;
	}
	
	public void setNom(String nom) {
		this.nom = nom;
	}

	/** 
	 * Permet de donner un indice
	 */
	public static void indice() {
		
		final String COULEUR = "couleur";
		final String CHIFFRE = "chiffre";
		String joueurSelectionne;
		String typeIndice;
		String IndiceCouleur;
		int IndiceChiffre;
		String indice;
		int NbCarte;

		Scanner entree = new Scanner(System.in);
		
		do {
		    System.out.print("Vous d�sirez donnez un indice � quel joueur ? ");
		    joueurSelectionne = entree.next();
		} while (!(joueurSelectionne.equals(gestionPartie.listeJoueur[0].getNom())) 
		         && !(joueurSelectionne.equals(gestionPartie.listeJoueur[1].getNom())) 
		         && !(joueurSelectionne.equals(gestionPartie.listeJoueur[2].getNom())));
		    
		do {
			System.out.print("Vous d�sirez donnez un indice sur la couleur ou le chiffre ? (�crivez en minuscule !) ");
			typeIndice = entree.next();
		} while (!(typeIndice.equals(COULEUR)) && !(typeIndice.equals(CHIFFRE)));
		
		do {
			System.out.print("Combien de cartes sont concern�es par cet indice ? (1 � 5) ");
			NbCarte = entree.nextInt();
		} while (NbCarte != 1 && NbCarte != 2 && NbCarte != 3 && NbCarte != 4 && NbCarte != 5);
		
		int[] IndiceCarte = new int[NbCarte];
		indice = joueurSelectionne + " votre/vos carte(s) ";

		
		for (int i = 0 ; i < IndiceCarte.length ; i++) {
			
			do {
				System.out.print("Indiquez une carte que vous voulez designer (carte num�rot� de gauche � droite de 1 � 5) : ");
				IndiceCarte[i] = entree.nextInt();
				indice += IndiceCarte[i] + ", ";
			} while (IndiceCarte[i] < 1 && IndiceCarte[i] > 5);		
		}
		if (typeIndice.equals(COULEUR)) {
			do {
				System.out.print("Indiquer quel couleur vous voulez indiquer (�crivez en minuscule !) : ");
				IndiceCouleur = entree.next();
			} while (!(IndiceCouleur.equals("rouge")) && !(IndiceCouleur.equals("bleu")) && !(IndiceCouleur.equals("blanc")) && !(IndiceCouleur.equals("rose")) && !(IndiceCouleur.equals("vert")));
            indice = indice.substring(0, indice.length()-1);
            indice = indice.substring(0, indice.length()-1);
            indice += " sont de couleur " + IndiceCouleur;
		} else {
			do {
				System.out.print("Indiquer quel chiffre vous voulez indiquer (1 � 5) : ");
				IndiceChiffre = entree.nextInt();
			} while (IndiceChiffre != 1 && IndiceChiffre != 2 && IndiceChiffre != 3 && IndiceChiffre != 4 && IndiceChiffre != 5);
			indice = indice.substring(0, indice.length()-1);
			indice = indice.substring(0, indice.length()-1);
            indice += " est/sont des " + IndiceChiffre;
		}
		System.out.println(indice);
	}

	
	/**
	 * permet de placer une carte (centre de la table)
	 */
	public static void poser() {
		
		Scanner entree = new Scanner(System.in);
		int indiceCarte;
		do {
		    System.out.print("choisir une carte a poser entre 1 et 5 :");
		    indiceCarte = entree.nextInt();
		} while (indiceCarte < 0 || indiceCarte > 5 );
		indiceCarte --;
		System.out.println("Vous avez poser la carte : " + main.get(indiceCarte).toStringCarte());
		main.remove(indiceCarte);				// on retire la carte de la main
		main.add(gestionPartie.deck.getCarte(0));	// on prend une carte de la pioche
		gestionPartie.deck.supprimerCarte(0);       // on supprime la carte de la pioche
		
		
	}
	
	
	/** 
	 * permet au joueur de d�fausser une carte
	 * @return c la carte d�fauss�e
	 */
	public static HanabiCarte defausser() {
		int carteChoisie;
		HanabiCarte c;
		Scanner entree = new Scanner(System.in);
		do {
		    System.out.print("choisir une carte a defausser entre 1 et 5 :");
		    carteChoisie = entree.nextInt();
		} while (carteChoisie < 0 || carteChoisie > 5);
		carteChoisie --;
		c = main.get(carteChoisie);
		System.out.println("Vous avez d�fausser la carte : " + main.get(carteChoisie).toStringCarte());
		main.remove(carteChoisie);
		main.add(gestionPartie.deck.getCarte(0));   // on prend une carte de la pioche
		gestionPartie.deck.supprimerCarte(0);       // on supprime la carte de la pioche
		
		return c;
		
	}

	/**
	 * permet au joueur d'ordonner ses cartes
	 * @return la main du joueur apr�s modification
	 */
	public static List<HanabiCarte> ordonner() {
	    int carte1;
	    int carte2;
	    Scanner entree = new Scanner(System.in);
	    do {
	        System.out.print("choisir la premiere carte a permuter entrez un chiffre entre 1 et 5 :");
	        carte1 = entree.nextInt();
	    } while (carte1 < 0 || carte1 > 5);
	    do {
	        System.out.print("choisir la deuxi�me carte a permuter entrez un chiffre entre 1 et 5 :");
	        carte2 = entree.nextInt();
	    } while (carte2 < 0 || carte2 > 5);
	    System.out.println("Vous avez interchanger la carte " + main.get(carte1 - 1).toStringCarte() + " avec la carte " + main.get(carte2 - 1).toStringCarte());
	    Collections.swap(main, carte1 - 1, carte2 - 1);            // permute les deux cartes  
	    return main;
	        
	}
    
    /**
     * permet de r�cup�rer la main d'un joueur
     * @return main du joueur
     */
    public List<HanabiCarte> getMain() {
        return this.main;
    }
    
    /**
     * permet de r�cup�rer la main d'un joueur sous forme de chaine de caract�re
     * @return main du joueur sous forme de chaine de caract�res
     */
    public String toStringMain() {
        String chaine = "";
        for (int i = 0; i < 5 ; i ++) {
            chaine += this.main.get(i).toStringCarte() + ", ";
        }
        return chaine;
    }

	
}