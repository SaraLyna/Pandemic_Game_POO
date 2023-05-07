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
	protected int GlobalInfectionRate = 2;
	protected int InfectionFocusAmount ;
	protected Stack<InfectionCards> infectionStack;
	protected Stack<PlayersCards> playersStack;
	
	
	/**
	 * @param GlobalInfectionRate
	 * @param InfectionFocusAmount
	 */
	public Game (int GlobalInfectionRate, int InfectionFocusAmount ){
		this.GlobalInfectionRate=GlobalInfectionRate;
		this.InfectionFocusAmount=InfectionFocusAmount;
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

