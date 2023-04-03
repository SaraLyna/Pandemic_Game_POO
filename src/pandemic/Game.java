package pandemic;

import java.util.Iterator;
import java.util.Stack;


public class Game {
	
	protected int GlobalInfectionRate;
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

	
	public static Iterator<String> keys() {
		// TODO Auto-generated method stub
		return null;
	}
	
	/**
	 * the most important method in the game, the method to play a party
	 */
	public void play() {
		
	}
	
	//public boolean isFinished(){
		//if( findRemedy() || InfectionFocusAmount == 8 || this.playersStack.size() < 2) {
			//return true;
		//}
		//else {
			//return false;
		//}
		
	//}
	
	

	/**
	 *Returns a string representation of the object.
	 */
	public String toString() {
		return "The global infection rate :"+this.GlobalInfectionRate + " and the infection focus amount "+this.InfectionFocusAmount;
	}


}

