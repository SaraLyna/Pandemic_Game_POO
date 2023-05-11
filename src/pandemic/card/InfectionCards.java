package pandemic.card;

import pandemic.Disease;
import pandemic.Game;

/**
 * this class represent the InfectionCards
 */
public class InfectionCards extends PlayersCards {
	
	/**
	 * constructor of the class InfectionCards
	 * @param cityName
	 * @param disease
	 */
	public InfectionCards(String cityName,Disease disease, Game game){
		super(cityName,disease, game);
	}
	
	
	/**
	 *@return  a string representation of the object.
	 */
	public String toString(){
		return " A card Infection for the city named "+ cityName +" and the disease "+disease;	
	}
	 
	    
}