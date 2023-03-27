package pandemic;

import java.util.Collections;
import java.util.*;

/**
 * this class represent the InfectionCards
 *
 */
public class InfectionCards extends Cards {
	
	private static ArrayList<InfectionCards> cards;
	/**
	 * constructor of the class InfectionCards
	 * @param city
	 * @param disease
	 */
	public InfectionCards(String cityName,String disease){
		super(cityName,disease);
	}
	protected void initCards() {
	    this.cards = new ArrayList<>();
	    this.cards.add(new PlayersCards("ville-19", "rouge"));
	    this.cards.add(new PlayersCards("ville-23", "rouge"));
	    this.cards.add(new PlayersCards("ville-24", "rouge"));
		this.cards.add(new PlayersCards("ville-25", "rouge"));
		this.cards.add(new PlayersCards("ville-29", "rouge"));
		this.cards.add(new PlayersCards("ville-30", "rouge"));
		this.cards.add(new PlayersCards("ville-31", "rouge"));
		this.cards.add(new PlayersCards("ville-35", "rouge"));
		this.cards.add(new PlayersCards("ville-36", "rouge"));
		this.cards.add(new PlayersCards("ville-37", "rouge"));
		this.cards.add(new PlayersCards("ville-42", "rouge"));
		this.cards.add(new PlayersCards("ville-48", "rouge"));
		this.cards.add(new PlayersCards("ville-2", "noir"));
		this.cards.add(new PlayersCards("ville-3", "noir"));
		this.cards.add(new PlayersCards("ville-8", "noir"));
		this.cards.add(new PlayersCards("ville-9", "noir"));
		this.cards.add(new PlayersCards("ville-10", "noir"));
		this.cards.add(new PlayersCards("ville-14", "noir"));
		this.cards.add(new PlayersCards("ville-15", "noir"));
		this.cards.add(new PlayersCards("ville-16", "noir"));
		this.cards.add(new PlayersCards("ville-20", "noir"));
		this.cards.add(new PlayersCards("ville-21", "noir"));
		this.cards.add(new PlayersCards("ville-22", "noir"));
		this.cards.add(new PlayersCards("ville-27", "noir"));
		this.cards.add(new PlayersCards("ville-1", "jaune"));
		this.cards.add(new PlayersCards("ville-5", "jaune"));
		this.cards.add(new PlayersCards("ville-6", "jaune"));
		this.cards.add(new PlayersCards("ville-7", "jaune"));
		this.cards.add(new PlayersCards("ville-12", "jaune"));
		this.cards.add(new PlayersCards("ville-13", "jaune"));
		this.cards.add(new PlayersCards("ville-17", "jaune"));
		this.cards.add(new PlayersCards("ville-18", "jaune"));
		this.cards.add(new PlayersCards("ville-38", "jaune"));
		this.cards.add(new PlayersCards("ville-43", "jaune"));
		this.cards.add(new PlayersCards("ville-44", "jaune"));
		this.cards.add(new PlayersCards("ville-47", "jaune"));
		this.cards.add(new PlayersCards("ville-4", "bleu"));
		this.cards.add(new PlayersCards("ville-11", "bleu"));
		this.cards.add(new PlayersCards("ville-26", "bleu"));
		this.cards.add(new PlayersCards("ville-28", "bleu"));
		this.cards.add(new PlayersCards("ville-32", "bleu"));
		this.cards.add(new PlayersCards("ville-33", "bleu"));
		this.cards.add(new PlayersCards("ville-34", "bleu"));
		this.cards.add(new PlayersCards("ville-39", "bleu"));
		this.cards.add(new PlayersCards("ville-40", "bleu"));
		this.cards.add(new PlayersCards("ville-41", "bleu"));
		this.cards.add(new PlayersCards("ville-45", "bleu"));
		this.cards.add(new PlayersCards("ville-46", "bleu"));
		
	}
	
	/**
	 *Returns a string representation of the object.
	 */
	public String toString(){
		return "InfectionCards for the city "+cityName+" and the disease "+disease;
		
	}
	
	
	  /**
	 * @param card
	 * add an InfectionCard in the list of cards
	 */
	public void addCarte(InfectionCards card) {
	        cartes.add(card);
	    }

	    /**
	     * shuffle the list of cards
	     */
	 protected static void melanger() {
	        Collections.shuffle(cartes);
	    }

	 
	    /**
	     * @return a card from the pack
	     */
	    public Cards tirerCarte() {
	        Cards carte = cartes.get(0);
	        cartes.remove(0);
	        return carte;
	    }

	    /**
	     * @return number of cards
	     */
	    public int nbCartes() {
	        return cartes.size();
	    }
	    
}