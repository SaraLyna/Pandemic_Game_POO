package pandemic;
import java.util.Stack;

import pandemic.PlayersCards;

/**
 * this class represent the action of the Expert
 *
 */
public class ExpertRole extends Actions {
	//en relation avec l'action construire
	//n’a pas besoin de disposer de carte joueur pour construire une station
	private String name;
	
	
	/**
	 * @param cartes
	 * @param city
	 * @param player
	 */
	public void BuildStationWoCard(Stack<PlayersCards> cartes,Cities city, Players player) {
				
		
		System.out.println("La station de recherche construite dans la ville est :" + city);
		
	}
	
	

}
