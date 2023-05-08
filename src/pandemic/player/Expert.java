package pandemic.player;

import pandemic.City;
import pandemic.Game;
import pandemic.ResearchCenterException;
import pandemic.card.Card;

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
	
	
	/** IF THE PLAYER IS AN EXPERT, chooseCard() WILL RETURN NULL, WHICH WILL BE FED TO THIS
	 * overrides the method from Player
	 * this method builds a research station without a card to build it
	 * and if there is already a station it throws an exception
	 * 
	 * This takes a parameter cardToDiscard to have the same signature as Player.construct() and override it, but this parameter will not be used.
	 * @param cardToDiscard can be anything, unused in the method besides for the signature
	 */
	public void construct(Card cardToDiscard) throws ResearchCenterException {
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
	
	/* returns null as expert does need to choose anything
	 * 
	 **/
	public Card chooseCard() {
		return null;
	}
	
	/** overriden for Expert who does not need any card to construct
	 * @return true if that city doesn't have a research center yet.
	 * 
	 * */
	public boolean playerCanConstruct() {
		boolean cityDoesntHaveResearchCenter = !this.getLocation().isResearchCenter();
		return (cityDoesntHaveResearchCenter);
	}
	

}
