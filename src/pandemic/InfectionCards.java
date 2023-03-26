package pandemic;

import java.util.Collections;
import java.util.*;

/**
 * this class represent the InfectionCards
 *
 */
public class InfectionCards extends Cards {
	
	private static ArrayList<InfectionCards> cartes;
	/**
	 * constructor of the class InfectionCards
	 * @param city
	 * @param disease
	 */
	public InfectionCards(String cityName,String disease){
		super(cityName,disease);
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