package pandemic.card;

import pandemic.*;
/**
 * this class represent the EpidemicCards
 *
 */
public class EpidemicCards extends Card {
	
	/**
	 * constructor of the class EpidemicCards
	 */
	public EpidemicCards(Game game) {
		super(game);
	}
	
	
	/**
	 *@return  a string representation of the object.
	 */
	public String toString(){
		return "A card Epidemic." ;		
	}
	


	@Override
	public void sideEffectWhenDrawn() {
		this.game.epidemyPhaseOfInfection();
		
	}
	
	

}
