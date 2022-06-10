/*
 * HanabiCarte.java                                                    05/22
 */

package carte;

/**
 * Permet de créer une carte du jeu hanabi
 * @author Idrissi Mohammed, Eléanor Mourgues, Charlie Sarrato-Boudet
 *
 */

public class HanabiCarte {
	
	public final Couleur couleur;
	public final Valeur valeur;
	
	public HanabiCarte(Couleur couleur, Valeur valeur) {
		this.couleur = couleur;
		this.valeur = valeur;
	}
	
	public Couleur getCouleur( ) {
		return this.couleur;
	}
	
	public Valeur getValeur( ) {
		return this.valeur;
	}
	
	public String toStringCarte() {
		return valeur + "_" + couleur;
	}
}
