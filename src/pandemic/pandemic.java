package pandemic;

import java.util.Iterator;

public class pandemic {
	private int GlobalInfectionRate;
	private int InfectionFocusAmount ;
	
	public pandemic (int GlobalInfectionRate, int InfectionFocusAmount ){
		this.GlobalInfectionRate=GlobalInfectionRate;
		this.InfectionFocusAmount=InfectionFocusAmount;
	}

	public static Iterator<String> keys() {
		// TODO Auto-generated method stub
		return null;
	}
	public void play() {
		
	}
	/*public boolean isFinished(){
		if() {
			return true;
		}
		else {
			return false;
		}
		
	}
	*/
	public String toString() {
		return "the global infection rate :"+this.GlobalInfectionRate + " and the infection focus amount "+this.InfectionFocusAmount;
	}
	}
