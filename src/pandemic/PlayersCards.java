package pandemic;

import java.util.ArrayList;
import java.util.Collections;

/**
 * 
 *
 */
public class PlayersCards extends Cards{
	private ArrayList<PlayersCards> cartes;
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
	
	 public void addCarte(PlayersCards card) {
	        cartes.add(card);
	    }

	    protected void melanger() {
	        Collections.shuffle(cartes);
	    }

	    public Cards tirerCarte() {
	        Cards carte = cartes.get(0);
	        cartes.remove(0);
	        return carte;
	    }

	    public int nbCartes() {
	        return cartes.size();
	    }
}
