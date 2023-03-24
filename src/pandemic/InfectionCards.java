package pandemic;

import java.util.Collections;
import java.util.*;

/**
 * this class represent the InfectionCards
 *
 */
public class InfectionCards extends Cards {
	
	private ArrayList<InfectionCards> cartes;
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
	  public void addCarte(InfectionCards card) {
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