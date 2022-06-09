/*
 * Classe permettant de tester la classe Joueur
 * testJoueur.java                                                    05/22
 */

package tests;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import carte.Couleur;
import carte.Deck;
import carte.HanabiCarte;
import carte.Valeur;
import code.Joueur;


/** 
 * Tests unitaires de {@link code.Joueur}
 * @author Mourgues El�anor
 */
public class testJoueur {
	
	 /** Jeux de tests utiles pour tester plusieurs m�thodes */
	 public static Joueur[] aTester = {
		       new Joueur("Mike"),
		       new Joueur("Terminator666"),
		       new Joueur("78Kira14"),
		    };
	 
	 /**
	 * TODO commenter le r�le du champ
	 */
	public static Joueur[] aModifier = {
		       new Joueur("Mike"),
		       new Joueur("Terminator666"),
		       new Joueur("78Kira14"),
		    };
	
	public static List<HanabiCarte> main = new ArrayList<HanabiCarte>(5);
	static Deck deck = new Deck();
	
	static Joueur JoueurActuel = new Joueur("Mike");
	
	
	/** 
     * Lancement des m�thodes de tests avec v�rification des �checs
     * @param args non utilis�
     */
    public static void main(String[] args) {
    	boolean ok;
    	String chaine = "";
    	
    	for (int i = 0; i < 5; i++) {
    	    JoueurActuel.main.add(i, deck.getCarte(0));
    	    deck.supprimerCarte(0);
    	}
  	
//    	ok = testJoueur();
//    	ok &= testGetNom();
//    	ok &= testSetNom();
//    	
//    	if (ok) {
//            System.out.println("tests r�ussis");
//        } else {
//            System.err.println("tests getNom �choue");
//        }
    	
    	Joueur.indice();
    	
    	
    	System.out.println(JoueurActuel.toStringMain());
//     	JoueurActuel.poser();
//    	JoueurActuel.defausser();
//    	JoueurActuel.ordonner();
    	System.out.println(JoueurActuel.toStringMain());
    	
    	
    }

    /**
     * tests visant � v�rifier qu le constructeur d'un joueur est op�rationnel
     * @return true si le test est bon false sinon
     */
	private static boolean testJoueur() {
		boolean testOK;
		
		try {
            new Joueur("  ");
            testOK = false;
        } catch (IllegalArgumentException nomVide) {
            testOK = true;
        }
		try {
            new Joueur(null);
            testOK = false;
        } catch (IllegalArgumentException nomNull) {
            testOK = true;
        }
		
		return testOK;
	}
	
	/**
	 * test de la m�thode getNom()
	 * @return true si les noms attendus correspondent aux noms r�cup�r� par le guetter
	 */
	private static boolean testGetNom() {
        
        String[] nomAttendue = {
            "Mike","Terminator666","78Kira14"      
        };
        
        boolean ok;
        
        ok = true;
        for (int noJeu = 0; ok && noJeu < aTester.length; noJeu++) {
            ok &= (nomAttendue[noJeu] == aTester[noJeu].getNom());
            
        }
        return ok; 
    }
	
	/**
	 * test de la m�thode SetNom()
	 * @return true si les noms attendus correspondent aux noms modifi�s par le setter
	 */
	private static boolean testSetNom() {
		 boolean ok;
		 
		 String[] nomAttendue = {
		            "Francois","Ultron45","89Kusco41"      
		        };
	        
	     ok = true;
	     for (int noJeu = 0; ok && noJeu < aModifier.length; noJeu++) {
	    	 aModifier[noJeu].setNom(nomAttendue[noJeu]);
	         ok &= (nomAttendue[noJeu] == aModifier[noJeu].getNom());
	            
	     }
	     return ok; 
	}
	

	/* les m�thode suivantes ont �t� tester � la main � cause de la pr�sence d'un scanner */
	/* indice () */
	/* poser() */
	/* defausser() */
	/* ordonner() */

}
