package pandemic.player;

import pandemic.City;
import pandemic.Game;
import pandemic.ResearchCenterException;

/**
 * this class represents the action of the Expert
 *
 */
public class Expert extends Player {
	/**
	c'est en relation avec l'action construire
	il n’a pas besoin de disposer de carte joueur pour construire une station
	 */
	
	/**
	 * constructor of the class ExpertRole
	 * @param name
	 * @param city
	 */
	public Expert(String name, City city, Game game) {
		super(name,city,game);
	}
	
	
	/** overrides the method from Player
	 * this method builds a research station without a card to build it
	 * and if there is already a station it throws an exception
	 * @param city
	 * 
	 */
	public void construct() throws ResearchCenterException {
		City currentLocation = this.getLocation();
		if(! currentLocation.isResearchCenter() && this.game.getNumberOfResearchCenter() < 6) {
			currentLocation.addResearchCenter();
			System.out.println("A new research station was built by the expert in :" + currentLocation.getName());
			currentLocation.setisResearchCenter();
			this.game.setNumberOfResearchCenter(this.game.getNumberOfResearchCenter() + 1);

		}
		else {
			//System.out.println("this city already has a research center");
			throw new ResearchCenterException("this city already has a research station");
		}	
	}
	

}
