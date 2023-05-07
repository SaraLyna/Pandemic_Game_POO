package pandemic;

import java.util.Iterator;
import java.util.Stack;

/* TODO déplacer toutes les méthodes de main ici, et rédiger le reste*/

/**
 * Class to run the pandemic game simulation.
 *
 */
public class Game {
	
	/*
	 *  all the necessary data to be stored for the game, will be accessed by other classes by passing the Game instance to them
	 */
	
	//TODO terminer la docu des attributs
	//TODO créer tous les getters et setters nécessaires
	protected int GlobalInfectionRate;
	protected Stack<InfectionCards> infectionStack;
	protected Stack<PlayersCards> playersStack;
	
	
	/**
	 * Builds an instance of Game by creating all its necessary components : map, players, etc.
	 *  @param mapFile The name of the file that contains city data
	 *  @param playerNumber The numbers of players for this game, should be between 2 and 4 included.
	 *  @param GlobalInfectionRate Should be 2 for the classic version of the game.
	 *	
	 */
	public Game (String mapFile, int numPlayers, int GlobalInfectionRate){
		this.GlobalInfectionRate=GlobalInfectionRate;
		
		if ( (numPlayers<2) || (numPlayers>4) ) {
			System.out.println("Error : invalid number of players"); //TODO facultatif : mettre ça en exception
		} 
		
		//TODO créer [playerNumber] joueurs
		
	}

	
	/**
	 * @return null
	 */
	public static Iterator<String> keys() {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	/**
	 * the most important method in the game, the method to play a party
	 */
	public void play() {
		
		//INIT
		
	    int overallInfectionRate = 2; // Le taux global d'infection 
	    MappeMonde Map;
	    //TODO récupérer map depuius les args
	    
		//TODO faire ici tout ce que le main faisait 
	}
	
	
	/**
	 * 
	determines whether the game is finished
	public boolean isFinished(){
		if( findRemedy() || InfectionFocusAmount == 8 || this.playersStack.size() < 2) {
			return true;
		}
		else {
			return false;
		}
		
	}
	 */
	
	

	/**
	 *@return a string representation of the object.
	 */
	public String toString() {
		return "The global infection rate : "+this.GlobalInfectionRate + " and the infection focus amount "+this.InfectionFocusAmount;
	}


}

