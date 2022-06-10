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
 * @author Idrissi Mohammed, Eléanor Mourgues, Charlie Sarrato-Boudet
 */
public class testJoueur {
	
	 /** Jeux de tests utiles pour tester plusieurs méthodes */
	 public static Joueur[] aTester = {
		       new Joueur("Mike"),
		       new Joueur("Terminator666"),
		       new Joueur("78Kira14"),
		    };
	 
	 /**
	 * TODO commenter le rôle du champ
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
     * Lancement des méthodes de tests avec vérification des échecs
     * @param args non utilisé
     */
    public static void main(String[] args) {
    	boolean ok;
    	String chaine = "";
    	
    	for (int i = 0; i < 5; i++) {
    	    JoueurActuel.main.add(i, deck.getCarte(0));
    	    deck.supprimerCarte(0);
    	}
  	
    	ok = testJoueur();
    	ok &= testGetNom();
   	ok &= testSetNom();
    	
    	if (ok) {
            System.out.println("tests réussis");
        } else {
            System.err.println("tests getNom échoue");
        }
    	
    	Joueur.indice();
    	
    	
    	System.out.println(JoueurActuel.toStringMain());
     	JoueurActuel.poser();
    	JoueurActuel.defausser();
    	JoueurActuel.ordonner();
    	System.out.println(JoueurActuel.toStringMain());
    	
    	
    }

    /**
     * tests visant à vérifier qu le constructeur d'un joueur est opérationnel
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
	 * test de la méthode getNom()
	 * @return true si les noms attendus correspondent aux noms récupéré par le guetter
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
	 * test de la méthode SetNom()
	 * @return true si les noms attendus correspondent aux noms modifiés par le setter
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
	

	/* les méthode suivantes ont été tester à la main à cause de la présence d'un scanner */
	/* indice () */
	/* poser() */
	/* defausser() */
	/* ordonner() */

}
