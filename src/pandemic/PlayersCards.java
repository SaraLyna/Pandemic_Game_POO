package pandemic;

import java.util.ArrayList;
import java.util.Collections;

/**
 * 
 *
 */
public class PlayersCards extends Cards{
	private static ArrayList<PlayersCards> cartes;
	/**
	 * @param city
	 * @param disease
	 */
	public PlayersCards(String cityName,String disease) {
		super(cityName,disease);
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
