/*
 * Deck.java                                                    05/22
 */

package carte;

import static carte.Couleur.values;
import static java.util.Collections.shuffle;
import static carte.Valeur.*;
import carte.HanabiCarte;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * permet la création d'un deck de cartes
 * @author Idrissi Mohammed, Eléanor Mourgues, Charlie Sarrato-Boudet
 */

public class Deck {

	private final List<HanabiCarte> cartes;

	private static Deck instance;

	public Deck() {
		cartes = init();
	}

	public static final Deck getInstance() {
		if (instance == null) {
			instance = new Deck();
		}
		return instance;
	}

	private static List<HanabiCarte> init() {
		List<HanabiCarte> cartes = new ArrayList<HanabiCarte>();

		for (Couleur couleur : values()) {
			cartes.add(new HanabiCarte(couleur, cinq));
			cartes.add(new HanabiCarte(couleur, quatre));
			cartes.add(new HanabiCarte(couleur, quatre));
			cartes.add(new HanabiCarte(couleur, trois));
			cartes.add(new HanabiCarte(couleur, trois));
			cartes.add(new HanabiCarte(couleur, deux));
			cartes.add(new HanabiCarte(couleur, deux));
			cartes.add(new HanabiCarte(couleur, un));
			cartes.add(new HanabiCarte(couleur, un));
			cartes.add(new HanabiCarte(couleur, un));
		}
 		shuffle(cartes);
		return cartes;
	}
	
	/**
	 * @return la taille de la liste
	 */
	public int size() {
		return cartes.size();
	}
	
	
	/**
	 * permet de prendre une carte du deck
	 * @return
	 */
	public HanabiCarte getCarte(int i) {
		return cartes.get(i);
	}
	
	/**
     * permet de supprime une carte du deck
     * @return
     */
    public HanabiCarte supprimerCarte(int i) {
        return cartes.remove(i);
    }
	
	/**
	 * méthode toString pour le deck
	 * @return le deck sous forme de chaine de caractères
	 */
	public String toString() {
	    String chaine;
	    chaine = "";
	    for (int i = 0 ; i < cartes.size(); i++) {
	        chaine += "[" + this.getCarte(i).toStringCarte() + "], \n";
	    }
	    chaine = chaine.substring(0, chaine.length()-1);
	    chaine = chaine.substring(0, chaine.length()-1);
        return chaine;
	}
}
