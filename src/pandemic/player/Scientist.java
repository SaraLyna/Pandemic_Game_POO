package pandemic.player;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Stack;

import pandemic.City;
import pandemic.Disease;
import pandemic.Game;
import pandemic.card.Card;

/**
 * this class represents the action of the Scientist
 *
 */
class Scientist extends Player {
	/**
	il a besoin de disposer que de 4 cartes joueur d’une même maladie pour découvrir
	un remède. C’est donc en relation avec l’action découvrir un remède
	 */
	
	private int handSize=4;
	
	/**
	 * constructor of the class ScientistRole
	 * @param name
	 * @param handSize
	 */
	public Scientist (String name, City city, Game game, int handSize) {
		super(name,city, game);
		this.handSize=handSize;
	}
	
	

	
	/**
	 * @return the number of cards ih the hand of the player ==4
	 */
	public int getSize() {
		return this.handSize;
	}	
	
	/**
	 * method equals
	 */
	public boolean equals(Object o) {
	    if (o == this) {
	        return true;
	    }
	    if (!(o instanceof Card)) {
	        return false;
	    }
	    Card card = (Card) o;
	    return this.name.equals(card.getDiseaseName());
	}
	
	
	
	
	/**
	 * @param diseases
	 * @param diseaseToCure
	 * @return a boolean
	 * méthode findRemedy qui permettrait de trouver un remede pour une maladie donnée 
	 * en utilisant la méthode discoverCure définie plus haut 
	 */
	public void healDisease(Disease diseaseToCure, City city) {
				
		ArrayList<Card> hand = this.getCardsInHand();
		
		//TODO récupérer la méthode de ScientistRole et l'adapter
		
		//TODO IMPLEMENTER RANDOMLISTCHOOSER DANS CETTE METHODE POUR AUTOMATISER
	    
		
	}
}