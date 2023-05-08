package pandemic.player;
import pandemic.card.Card;
import java.util.ArrayList;
import java.util.Iterator;
import pandemic.City;
import pandemic.Disease;
import pandemic.Game;

/**
 * this class represents the action of the Scientist
 *
 */
class Scientist extends Player {
	/**
	il a besoin de disposer que de 4 cartes joueur d’une même maladie pour découvrir
	un remède. C’est donc en relation avec l’action découvrir un remède
	 */
	
	private int handSize=4; //TODO VOIR A QUOI CA SERT
	
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
	
	
	
	
	/** A SUPPRIMER, CONTENU DANS LA CLASSE MERE PLAYER
	 * @param diseases
	 * @param diseaseToCure
	 * @return a boolean
	 * méthode findRemedy qui permettrait de trouver un remede pour une maladie donnée 
	 * en utilisant la méthode discoverCure définie plus haut 
	 
	public void healDisease(Disease diseaseToCure, City city) {
				
		ArrayList<Card> hand = this.getCardsInHand();
		
		//TODO récupérer la méthode de ScientistRole et l'adapter
		
		//TODO IMPLEMENTER RANDOMLISTCHOOSER DANS CETTE METHODE POUR AUTOMATISER
	    
		
	}*/
	
	
	/**
     * @param p
     * @param Disease
	 * check if the city has a Research Center and discover a Cure for a specific disease.
	 * Then discard the 5 players cards.
     */
    public  void discover(Disease Disease){
    	int cpt = 0;
		ArrayList<Card> hand = this.getCardsInHand();
		City city = this.getLocation();
		if (city.isResearchCenter()){
			Iterator<Card> it = hand.iterator();
			while (it.hasNext()) {	
				Card card = it.next();
				if(card.getDiseaseName()==Disease.getDiseaseName()) {
					cpt += 1;
				}
			}
			if (cpt > 4) {
				Disease.setCured(true);
				while (it.hasNext()) {
					Card card = it.next();
					if(card.getDiseaseName()==Disease.getDiseaseName()) {
						this.removeCard(card);
					}
				}
			System.out.println("A cure has been found for the disease " + Disease.getDiseaseName());
			}
			else {
				System.out.println(this.toString() + " has not enough cards to cure the disease " + Disease.getDiseaseName());
			}
		}
		else {
			System.out.println(this.toString() + ", please build a research Center to discover a Cure for the disease " + Disease.getDiseaseName());
		}
    }

}