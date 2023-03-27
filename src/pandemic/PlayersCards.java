package pandemic;

import java.util.ArrayList;
import java.util.Collections;

/**
 * 
 *
 */
public class PlayersCards extends Cards{
	private static ArrayList<PlayersCards> cards;
	/**
	 * @param city
	 * @param disease
	 */
	public PlayersCards(String cityName,String disease) {
		super(cityName,disease);
	}
	protected void initCards() {
		PlayersCards.cards = new ArrayList<>();
		PlayersCards.cards.add(new PlayersCards("ville-19", "rouge"));
	    PlayersCards.cards.add(new PlayersCards("ville-23", "rouge"));
	    PlayersCards.cards.add(new PlayersCards("ville-24", "rouge"));
		PlayersCards.cards.add(new PlayersCards("ville-25", "rouge"));
		PlayersCards.cards.add(new PlayersCards("ville-29", "rouge"));
		PlayersCards.cards.add(new PlayersCards("ville-30", "rouge"));
		this.cards.add(new PlayersCards("ville-31", "rouge"));
		this.cards.add(new PlayersCards("ville-35", "rouge"));
		this.cards.add(new PlayersCards("ville-36", "rouge"));
		PlayersCards.cards.add(new PlayersCards("ville-37", "rouge"));
		PlayersCards.cards.add(new PlayersCards("ville-42", "rouge"));
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
	public String toString() {
		return "A player card for the city named "+cityName+" and the disease "+disease;
	}
	
	 /**
	 * @param card
	 * add a Playerscard 
	 */
	public void addCarte(PlayersCards card) {
	        cartes.add(card);
	    }

	    /**
	     * shuffle the cards
	     */
	    public static void melanger() {
			Collections.shuffle(cartes);
			
	    }

	    /**
	     * @param cartes
	     * @return a card
	     */
	    public Cards tirerCarte( ArrayList<PlayersCards> cartes) {
	        Cards carte = cartes.get(0);
	        cartes.remove(0);
	        return carte;
	    }

	    /**
	     * @return the number of cards
	     */
	    public int nbCartes() {
	        return cartes.size();
	    }
}
