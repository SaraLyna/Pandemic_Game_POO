package pandemic;

/**
 * this class represent the InfectionCards
 *
 */
public class InfectionCards extends Cards {
	
	/**
	 * constructor of the class InfectionCards
	 * @param city
	 * @param disease
	 */
	public InfectionCards(String cityName,String disease){
		super(cityName,disease);
	}
	
	
	/**
	 *Returns a string representation of the object.
	 */
	public String toString(){
		return "  an infection card for the city named "+ cityName +" and the disease "+disease;
		
	}
	
	
	 
	    
}