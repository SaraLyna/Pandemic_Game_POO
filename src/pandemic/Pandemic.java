package pandemic;

import java.util.Iterator;
import java.util.Stack;

public class Pandemic {
	
	protected int GlobalInfectionRate;
	protected int InfectionFocusAmount ;
	protected Stack<InfectionCards> infectionStack;
	protected Stack<PlayersCards> playersStack;
	
	
	public Pandemic (int GlobalInfectionRate, int InfectionFocusAmount ){
		this.GlobalInfectionRate=GlobalInfectionRate;
		this.InfectionFocusAmount=InfectionFocusAmount;
	}

	public static Iterator<String> keys() {
		// TODO Auto-generated method stub
		return null;
	}
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

	public String toString() {
		return "the global infection rate :"+this.GlobalInfectionRate + " and the infection focus amount "+this.InfectionFocusAmount;
	}


}

